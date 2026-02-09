package com.diginest.aiagents.service;

import com.diginest.aiagents.model.entity.ContactRequest;
import com.diginest.aiagents.model.entity.DemoRequest;
import com.diginest.aiagents.repository.ContactRepository;
import com.diginest.aiagents.repository.DemoRepository;
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
    private final DemoRepository demoRepository;

    @Value("${app.email.from:contact@generativa.ro}")
    private String fromEmail;

    @Value("${app.email.admin:contact@generativa.ro}")
    private String adminEmail;

    @Value("${app.email.enabled:true}")
    private boolean emailEnabled;

    @Value("${MAIL_PASSWORD:}")
    private String resendApiKey;

    public EmailService(ContactRepository contactRepository, DemoRepository demoRepository) {
        this.restTemplate = new RestTemplate();
        this.contactRepository = contactRepository;
        this.demoRepository = demoRepository;
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
                "[GENERATIVA] New Contact Request from " + (request.getCompany() != null ? request.getCompany() : request.getName()),
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

    // ========== DEMO REQUEST EMAILS ==========

    /**
     * Send both notification and confirmation emails for a demo request, then mark as processed.
     * Runs asynchronously - does not block the HTTP response.
     */
    @Async
    public void sendAllDemoEmails(DemoRequest request) {
        log.info("Email enabled status: {}", emailEnabled);
        if (!emailEnabled) {
            log.info("Email disabled - skipping all emails for demo request {}", request.getId());
            return;
        }

        boolean adminSent = false;
        boolean confirmSent = false;

        // Send admin notification
        try {
            sendViaResend(
                adminEmail,
                "[GENERATIVA] Demo Request from " + request.getCompany() + " (" + request.getIndustry() + ")",
                buildDemoAdminNotificationText(request)
            );
            adminSent = true;
            log.info("Admin notification sent for demo request {}", request.getId());
        } catch (Exception e) {
            log.error("Failed to send admin notification for demo request {}: {}",
                request.getId(), e.getMessage());
        }

        // Send confirmation to user only if admin notification succeeded
        if (adminSent) {
            try {
                sendViaResend(
                    request.getEmail(),
                    getDemoConfirmationSubject(request.getLocale()),
                    buildDemoConfirmationHtml(request),
                    true  // Send as HTML
                );
                confirmSent = true;
                log.info("Demo confirmation email sent to {} for demo request {}",
                    request.getEmail(), request.getId());
            } catch (Exception e) {
                log.error("Failed to send demo confirmation email for demo request {}: {}",
                    request.getId(), e.getMessage());
            }
        } else {
            log.warn("Skipping demo confirmation email - admin notification failed for request {}", request.getId());
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
            demoRepository.save(request);
            log.info("Demo request {} marked as processed={}", request.getId(), request.isProcessed());
        } catch (Exception e) {
            log.error("Failed to update processed status for demo request {}: {}",
                request.getId(), e.getMessage());
        }
    }

    private String getDemoConfirmationSubject(String locale) {
        return "en".equals(locale)
            ? "Your personalized demo is being prepared - GENERATIVA"
            : "Demo-ul t\u0103u personalizat este \u00een preg\u0103tire - GENERATIVA";
    }

    private String buildDemoAdminNotificationText(DemoRequest request) {
        return String.format("""
            NEW DEMO REQUEST - Priority Lead!

            Contact Details:
            Name: %s
            Email: %s
            Phone: %s
            Company: %s

            Business Details:
            Industry: %s
            Problem to solve: %s
            Additional details: %s

            GDPR Consent: %s

            ---
            IP: %s
            Source: %s
            Locale: %s
            Time: %s
            """,
            request.getName(),
            request.getEmail(),
            request.getPhone(),
            request.getCompany(),
            request.getIndustry(),
            request.getProblem(),
            request.getDetails() != null ? request.getDetails() : "Not provided",
            request.isGdprConsent() ? "Yes" : "No",
            request.getIpAddress(),
            request.getSource(),
            request.getLocale(),
            request.getCreatedAt()
        );
    }

    /**
     * Build HTML confirmation email for demo request.
     *
     * Design: Stripe/Linear-inspired enterprise B2B email.
     * Content: Confirms receipt, explains next steps (24h contact, 20-30min personalized demo).
     * Layout: table-based for maximum email client compatibility.
     * Styles: 100% inline CSS (no <style> tags, no flexbox/grid).
     * i18n: Single template, locale-driven text via ternary operators.
     */
    private String buildDemoConfirmationHtml(DemoRequest request) {
        boolean en = "en".equals(request.getLocale());

        // Extract first name for greeting
        String firstName = request.getName().contains(" ")
            ? request.getName().substring(0, request.getName().indexOf(" "))
            : request.getName();

        // Escape HTML entities in user content
        firstName = escapeHtml(firstName);
        String companyEscaped = escapeHtml(request.getCompany());
        String industryEscaped = escapeHtml(request.getIndustry());
        String problemEscaped = escapeHtml(request.getProblem());

        // --- i18n text blocks ---
        String greeting = en
            ? "Hi " + firstName + ","
            : "Bun\u0103 " + firstName + ",";

        String mainText = en
            ? "Thank you for requesting a personalized demo. We\u2019ve received your details and our team is already preparing a demo tailored to <strong style=\"color:#18181b;\">" + companyEscaped + "</strong>."
            : "\u00CE\u021Bi mul\u021Bumim c\u0103 ai solicitat un demo personalizat. Am primit datele tale \u0219i echipa noastr\u0103 preg\u0103te\u0219te deja un demo adaptat pentru <strong style=\"color:#18181b;\">" + companyEscaped + "</strong>.";

        String stepsTitle = en ? "What happens next?" : "Ce urmeaz\u0103?";

        String step1 = en
            ? "<strong style=\"color:#18181b;\">Within 24 hours</strong> \u2014 a GENERATIVA consultant will contact you to schedule the demo at a time that suits you."
            : "<strong style=\"color:#18181b;\">\u00CEn maxim 24 de ore</strong> \u2014 un consultant GENERATIVA te va contacta pentru a programa demo-ul la o or\u0103 convenabil\u0103.";

        String step2 = en
            ? "<strong style=\"color:#18181b;\">20\u201330 minute demo</strong> \u2014 we\u2019ll show you an AI agent configured for your industry (" + industryEscaped + ") solving the exact problem you described."
            : "<strong style=\"color:#18181b;\">Demo de 20\u201330 minute</strong> \u2014 \u00ee\u021bi vom ar\u0103ta un agent AI configurat pentru domeniul t\u0103u (" + industryEscaped + ") care rezolv\u0103 exact problema descris\u0103.";

        String step3 = en
            ? "<strong style=\"color:#18181b;\">No obligation</strong> \u2014 the demo is completely free. You decide if GENERATIVA is right for your business."
            : "<strong style=\"color:#18181b;\">F\u0103r\u0103 obliga\u021Bii</strong> \u2014 demo-ul este complet gratuit. Tu decizi dac\u0103 GENERATIVA este potrivit\u0103 pentru afacerea ta.";

        String summaryLabel = en ? "Your request summary" : "Rezumatul solicit\u0103rii tale";
        String companyLabel = en ? "Company" : "Companie";
        String industryLabel = en ? "Industry" : "Domeniu";
        String problemLabel = en ? "Challenge" : "Provocare";

        String closing = en ? "Best regards," : "Cu stim\u0103,";
        String teamName = en ? "The GENERATIVA Team" : "Echipa GENERATIVA";

        String footerNote = en
            ? "This is an automated confirmation. A real person from our team will contact you within 24 hours."
            : "Acesta este un email automat de confirmare. O persoan\u0103 real\u0103 din echipa noastr\u0103 te va contacta \u00een maxim 24 de ore.";

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
  <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%%" style="background-color:#f4f4f5;">
    <tr>
      <td align="center" style="padding:40px 16px;">

        <!-- Inner container: 600px max width -->
        <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600" style="max-width:600px; width:100%%; background-color:#ffffff; border-radius:12px; overflow:hidden; border:1px solid #e4e4e7;">

          <!-- ====== HEADER: Logo ====== -->
          <tr>
            <td style="padding:32px 40px 24px 40px; border-bottom:1px solid #f4f4f5;">
              <table role="presentation" cellpadding="0" cellspacing="0" border="0">
                <tr>
                  <td style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:22px; font-weight:700; color:#18181b; letter-spacing:-0.02em;">
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

              <!-- Steps title -->
              <p style="margin:0 0 16px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:15px; line-height:1.6; color:#18181b; font-weight:600;">
                %STEPS_TITLE%
              </p>

            </td>
          </tr>

          <!-- ====== STEPS BOX ====== -->
          <tr>
            <td style="padding:0 40px 28px 40px;">
              <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%%" style="background-color:#f0fdfa; border-radius:8px; border:1px solid #ccfbf1;">
                <tr>
                  <td style="padding:20px 24px;">
                    <!-- Step 1 -->
                    <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%%" style="margin-bottom:14px;">
                      <tr>
                        <td width="28" valign="top" style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:14px; color:#06b6d4; font-weight:700; padding-top:1px;">1.</td>
                        <td style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:14px; line-height:1.6; color:#52525b;">%STEP1%</td>
                      </tr>
                    </table>
                    <!-- Step 2 -->
                    <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%%" style="margin-bottom:14px;">
                      <tr>
                        <td width="28" valign="top" style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:14px; color:#06b6d4; font-weight:700; padding-top:1px;">2.</td>
                        <td style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:14px; line-height:1.6; color:#52525b;">%STEP2%</td>
                      </tr>
                    </table>
                    <!-- Step 3 -->
                    <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%%">
                      <tr>
                        <td width="28" valign="top" style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:14px; color:#06b6d4; font-weight:700; padding-top:1px;">3.</td>
                        <td style="font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:14px; line-height:1.6; color:#52525b;">%STEP3%</td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>

          <!-- ====== SUMMARY BOX ====== -->
          <tr>
            <td style="padding:0 40px 32px 40px;">
              <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%%" style="background-color:#fafafa; border-radius:8px; border:1px solid #e4e4e7;">
                <tr>
                  <td style="padding:20px 24px;">
                    <!-- Label -->
                    <p style="margin:0 0 12px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:11px; font-weight:600; color:#a1a1aa; text-transform:uppercase; letter-spacing:0.05em;">
                      %SUMMARY_LABEL%
                    </p>
                    <!-- Company -->
                    <p style="margin:0 0 6px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:13px; line-height:1.5; color:#52525b;">
                      <span style="color:#a1a1aa;">%COMPANY_LABEL%:</span> <span style="color:#18181b;">%COMPANY%</span>
                    </p>
                    <!-- Industry -->
                    <p style="margin:0 0 6px 0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:13px; line-height:1.5; color:#52525b;">
                      <span style="color:#a1a1aa;">%INDUSTRY_LABEL%:</span> <span style="color:#18181b;">%INDUSTRY%</span>
                    </p>
                    <!-- Problem -->
                    <p style="margin:0; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:13px; line-height:1.5; color:#52525b;">
                      <span style="color:#a1a1aa;">%PROBLEM_LABEL%:</span> <span style="color:#18181b;">%PROBLEM%</span>
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
              <table role="presentation" cellpadding="0" cellspacing="0" border="0" width="100%%">
                <!-- Links row -->
                <tr>
                  <td style="padding-bottom:16px; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif; font-size:13px; line-height:1.5; color:#a1a1aa;">
                    <span style="color:#71717a;">%WEBSITE_LABEL%:</span>
                    <a href="https://generativa.ro" style="color:#06b6d4; text-decoration:none;" target="_blank">generativa.ro</a>
                    &nbsp;&nbsp;&middot;&nbsp;&nbsp;
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
            .replace("%SUBJECT%", getDemoConfirmationSubject(request.getLocale()))
            .replace("%GREETING%", greeting)
            .replace("%MAIN_TEXT%", mainText)
            .replace("%STEPS_TITLE%", stepsTitle)
            .replace("%STEP1%", step1)
            .replace("%STEP2%", step2)
            .replace("%STEP3%", step3)
            .replace("%SUMMARY_LABEL%", summaryLabel)
            .replace("%COMPANY_LABEL%", companyLabel)
            .replace("%COMPANY%", companyEscaped)
            .replace("%INDUSTRY_LABEL%", industryLabel)
            .replace("%INDUSTRY%", industryEscaped)
            .replace("%PROBLEM_LABEL%", problemLabel)
            .replace("%PROBLEM%", problemEscaped)
            .replace("%CLOSING%", closing)
            .replace("%TEAM_NAME%", teamName)
            .replace("%FOOTER_NOTE%", footerNote)
            .replace("%WEBSITE_LABEL%", websiteLabel)
            .replace("%EMAIL_LABEL%", emailLabel);
    }

    // ========== SHARED UTILITIES ==========

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
            request.getCompany() != null ? request.getCompany() : "Not provided",
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
