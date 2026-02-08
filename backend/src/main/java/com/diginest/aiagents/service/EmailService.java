package com.diginest.aiagents.service;

import com.diginest.aiagents.model.entity.ContactRequest;
import com.diginest.aiagents.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * Service for sending emails via Resend HTTP API.
 *
 * Uses Resend's REST API (https://api.resend.com/emails) instead of SMTP
 * because Railway blocks outbound SMTP ports (25, 465, 587).
 * HTTPS port 443 is always available.
 *
 * All email methods are @Async so the contact form responds immediately.
 * After both emails are sent, marks the contact request as processed in DB.
 */
@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    private static final String RESEND_API_URL = "https://api.resend.com/emails";

    private final RestTemplate restTemplate;
    private final ContactRepository contactRepository;

    @Value("${app.email.from:contact@generativa.ro}")
    private String fromEmail;

    @Value("${app.email.admin:contact@generativa.ro}")
    private String adminEmail;

    @Value("${app.email.enabled:true}")
    private boolean emailEnabled;

    @Value("${MAIL_PASSWORD:}")
    private String resendApiKey;

    public EmailService(ContactRepository contactRepository) {
        this.restTemplate = new RestTemplate();
        this.contactRepository = contactRepository;
    }

    /**
     * Send both notification and confirmation emails, then mark as processed.
     * Runs asynchronously - does not block the HTTP response.
     */
    @Async
    public void sendAllEmails(ContactRequest request) {
        log.info("Email enabled status: {}", emailEnabled);
        if (!emailEnabled) {
            log.info("Email disabled - skipping all emails for contact request {}", request.getId());
            return;
        }

        boolean adminSent = false;
        boolean confirmSent = false;

        // Send admin notification
        try {
            sendViaResend(
                adminEmail,
                "[GENERATIVA] New Contact Request from " + request.getCompany(),
                buildAdminNotificationText(request)
            );
            adminSent = true;
            log.info("Admin notification sent for contact request {}", request.getId());
        } catch (Exception e) {
            log.error("Failed to send admin notification for contact request {}: {}",
                request.getId(), e.getMessage());
        }

        // Send confirmation to user only if admin notification succeeded
        if (adminSent) {
            try {
                sendViaResend(
                    request.getEmail(),
                    getConfirmationSubject(request.getLocale()),
                    buildConfirmationHtml(request),
                    true  // Send as HTML
                );
                confirmSent = true;
                log.info("Confirmation email sent to {} for contact request {}",
                    request.getEmail(), request.getId());
            } catch (Exception e) {
                log.error("Failed to send confirmation email for contact request {}: {}",
                    request.getId(), e.getMessage());
            }
        } else {
            log.warn("Skipping confirmation email - admin notification failed for request {}", request.getId());
        }

        // Update processed status in database
        try {
            request.setProcessed(adminSent && confirmSent);
            request.setProcessedAt(Instant.now());
            if (!adminSent || !confirmSent) {
                request.setNotes(String.format("admin=%s, confirm=%s",
                    adminSent ? "sent" : "failed",
                    confirmSent ? "sent" : "failed"));
            }
            contactRepository.save(request);
            log.info("Contact request {} marked as processed={}", request.getId(), request.isProcessed());
        } catch (Exception e) {
            log.error("Failed to update processed status for contact request {}: {}",
                request.getId(), e.getMessage());
        }
    }

    /**
     * Send plain-text email via Resend HTTP API.
     */
    private void sendViaResend(String to, String subject, String text) {
        sendViaResend(to, subject, text, false);
    }

    /**
     * Send email via Resend HTTP API (port 443 - always available on cloud).
     * Supports both plain text and HTML content.
     */
    private void sendViaResend(String to, String subject, String content, boolean isHtml) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(resendApiKey);

        // Resend API accepts "html" for HTML content, "text" for plain text
        String contentKey = isHtml ? "html" : "text";

        Map<String, Object> body = Map.of(
            "from", fromEmail,
            "to", List.of(to),
            "subject", subject,
            contentKey, content
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(RESEND_API_URL, entity, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Resend API error: " + response.getStatusCode() + " - " + response.getBody());
        }

        log.debug("Resend API response: {}", response.getBody());
    }

    private String buildAdminNotificationText(ContactRequest request) {
        return String.format("""
            New contact request received!

            From: %s
            Email: %s
            Company: %s
            Phone: %s

            Message:
            %s

            ---
            IP: %s
            Source: %s
            Locale: %s
            Time: %s
            """,
            request.getName(),
            request.getEmail(),
            request.getCompany(),
            request.getPhone() != null ? request.getPhone() : "Not provided",
            request.getMessage(),
            request.getIpAddress(),
            request.getSource(),
            request.getLocale(),
            request.getCreatedAt()
        );
    }

    private String getConfirmationSubject(String locale) {
        return "en".equals(locale)
            ? "Thank you for contacting GENERATIVA"
            : "Mulțumim pentru mesaj - GENERATIVA";
    }

    /**
     * Build HTML confirmation email for the user.
     *
     * Design: Stripe/Linear-inspired enterprise B2B email.
     * Layout: table-based for maximum email client compatibility.
     * Styles: 100% inline CSS (no <style> tags, no flexbox/grid).
     * i18n: Single template, locale-driven text via ternary operators.
     * Tested for: Gmail, Outlook Desktop, Outlook Web, Apple Mail, Yahoo.
     */
    private String buildConfirmationHtml(ContactRequest request) {
        boolean en = "en".equals(request.getLocale());

        // Extract first name for greeting
        String firstName = request.getName().contains(" ")
            ? request.getName().substring(0, request.getName().indexOf(" "))
            : request.getName();

        // Truncate message for display (max 300 chars)
        String messagePreview = request.getMessage().length() > 300
            ? request.getMessage().substring(0, 300) + "..."
            : request.getMessage();

        // Escape HTML entities in user content
        messagePreview = escapeHtml(messagePreview);
        firstName = escapeHtml(firstName);

        // --- i18n text blocks ---
        String greeting = en
            ? "Hi " + firstName + ","
            : "Bun\u0103 " + firstName + ",";

        String mainText = en
            ? "Thank you for reaching out. We\u2019ve received your message and a member of our team will get back to you within <strong style=\"color:#18181b;\">24 hours</strong>."
            : "\u00CE\u021Bi mul\u021Bumim c\u0103 ne-ai contactat. Am primit mesajul t\u0103u \u0219i un membru al echipei noastre te va contacta \u00EEn maxim <strong style=\"color:#18181b;\">24 de ore</strong>.";

        String messageLabel = en ? "Your message" : "Mesajul t\u0103u";

        String closing = en ? "Best regards," : "Cu stim\u0103,";

        String teamName = en ? "The GENERATIVA Team" : "Echipa GENERATIVA";

        String footerNote = en
            ? "This is an automated confirmation, but every message is read and answered by our team."
            : "Acesta este un email automat de confirmare, dar fiecare mesaj este citit \u0219i tratat de echipa noastr\u0103.";

        String websiteLabel = en ? "Website" : "Website";
        String emailLabel = en ? "Email" : "Email";

        // --- HTML Template ---
        return """
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="%LOCALE%">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="color-scheme" content="light" />
  <meta name="supported-color-schemes" content="light" />
  <title>%SUBJECT%</title>
</head>
<body style="margin:0; padding:0; background-color:#f4f4f5; -webkit-font-smoothing:antialiased; -moz-osx-font-smoothing:grayscale;">

  <!-- Outer wrapper: full-width background -->
  <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%" style="background-color:#f4f4f5;">
    <tr>
      <td align="center" style="padding:40px 16px;">

        <!-- Inner container: 600px max width -->
        <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600" style="max-width:600px; width:100%; background-color:#ffffff; border-radius:12px; overflow:hidden; border:1px solid #e4e4e7;">

          <!-- ====== HEADER: Logo ====== -->
          <tr>
            <td style="padding:32px 40px 24px 40px; border-bottom:1px solid #f4f4f5;">
              <table role="presentation" cellpadding="0" cellspacing="0" border="0">
                <tr>
                  <td style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:22px; font-weight:700; color:#18181b; letter-spacing:-0.02em;">
                    <!-- Logo text with brand gradient simulation -->
                    <span style="color:#06b6d4;">G</span><span style="color:#18181b;">ENERATIVA</span>
                  </td>
                </tr>
              </table>
            </td>
          </tr>

          <!-- ====== BODY: Main content ====== -->
          <tr>
            <td style="padding:32px 40px 16px 40px;">

              <!-- Greeting -->
              <p style="margin:0 0 20px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:16px; line-height:1.6; color:#18181b; font-weight:500;">
                %GREETING%
              </p>

              <!-- Main text -->
              <p style="margin:0 0 28px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:15px; line-height:1.7; color:#52525b;">
                %MAIN_TEXT%
              </p>

            </td>
          </tr>

          <!-- ====== MESSAGE BOX: User's message ====== -->
          <tr>
            <td style="padding:0 40px 32px 40px;">
              <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%" style="background-color:#fafafa; border-radius:8px; border:1px solid #e4e4e7;">
                <tr>
                  <td style="padding:20px 24px;">
                    <!-- Label -->
                    <p style="margin:0 0 8px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:11px; font-weight:600; color:#a1a1aa; text-transform:uppercase; letter-spacing:0.05em;">
                      %MESSAGE_LABEL%
                    </p>
                    <!-- Message content -->
                    <p style="margin:0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:14px; line-height:1.65; color:#3f3f46; font-style:italic;">
                      %MESSAGE_PREVIEW%
                    </p>
                  </td>
                </tr>
              </table>
            </td>
          </tr>

          <!-- ====== CLOSING: Signature ====== -->
          <tr>
            <td style="padding:0 40px 32px 40px;">
              <p style="margin:0 0 4px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:15px; line-height:1.6; color:#52525b;">
                %CLOSING%
              </p>
              <p style="margin:0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:15px; line-height:1.6; color:#18181b; font-weight:600;">
                %TEAM_NAME%
              </p>
            </td>
          </tr>

          <!-- ====== FOOTER ====== -->
          <tr>
            <td style="padding:24px 40px; background-color:#fafafa; border-top:1px solid #f4f4f5;">
              <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%">
                <!-- Links row -->
                <tr>
                  <td style="padding-bottom:16px; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:13px; line-height:1.5; color:#a1a1aa;">
                    <span style="color:#71717a;">%WEBSITE_LABEL%:</span>
                    <a href="https://generativa.ro" style="color:#06b6d4; text-decoration:none;" target="_blank">generativa.ro</a>
                    &nbsp;&nbsp;·&nbsp;&nbsp;
                    <span style="color:#71717a;">%EMAIL_LABEL%:</span>
                    <a href="mailto:contact@generativa.ro" style="color:#06b6d4; text-decoration:none;">contact@generativa.ro</a>
                  </td>
                </tr>
                <!-- Trust note -->
                <tr>
                  <td style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:12px; line-height:1.5; color:#a1a1aa;">
                    %FOOTER_NOTE%
                  </td>
                </tr>
              </table>
            </td>
          </tr>

        </table>
        <!-- /Inner container -->

      </td>
    </tr>
  </table>
  <!-- /Outer wrapper -->

</body>
</html>"""
            .replace("%LOCALE%", en ? "en" : "ro")
            .replace("%SUBJECT%", getConfirmationSubject(request.getLocale()))
            .replace("%GREETING%", greeting)
            .replace("%MAIN_TEXT%", mainText)
            .replace("%MESSAGE_LABEL%", messageLabel)
            .replace("%MESSAGE_PREVIEW%", messagePreview)
            .replace("%CLOSING%", closing)
            .replace("%TEAM_NAME%", teamName)
            .replace("%FOOTER_NOTE%", footerNote)
            .replace("%WEBSITE_LABEL%", websiteLabel)
            .replace("%EMAIL_LABEL%", emailLabel);
    }

    /**
     * Escape HTML special characters in user-provided content
     * to prevent XSS in email templates.
     */
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;");
    }
}
