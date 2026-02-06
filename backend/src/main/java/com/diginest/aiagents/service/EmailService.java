package com.diginest.aiagents.service;

import com.diginest.aiagents.model.entity.ContactRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
 */
@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    private static final String RESEND_API_URL = "https://api.resend.com/emails";

    private final RestTemplate restTemplate;

    @Value("${app.email.from:contact@generativa.ro}")
    private String fromEmail;

    @Value("${app.email.admin:contact@generativa.ro}")
    private String adminEmail;

    @Value("${app.email.enabled:true}")
    private boolean emailEnabled;

    @Value("${MAIL_PASSWORD:}")
    private String resendApiKey;

    public EmailService() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Send notification to admin about new contact request.
     */
    @Async
    public void sendContactNotification(ContactRequest request) {
        log.info("Email enabled status: {}", emailEnabled);
        if (!emailEnabled) {
            log.info("Email disabled - skipping admin notification for contact request {}", request.getId());
            return;
        }

        try {
            sendViaResend(
                adminEmail,
                "[GENERATIVA] New Contact Request from " + request.getCompany(),
                buildAdminNotificationText(request)
            );
            log.info("Admin notification sent for contact request {}", request.getId());
        } catch (Exception e) {
            log.error("Failed to send admin notification for contact request {}: {}",
                request.getId(), e.getMessage());
        }
    }

    /**
     * Send confirmation email to the user who submitted the contact form.
     */
    @Async
    public void sendContactConfirmation(ContactRequest request) {
        if (!emailEnabled) {
            log.info("Email disabled - skipping confirmation for contact request {}", request.getId());
            return;
        }

        try {
            sendViaResend(
                request.getEmail(),
                getConfirmationSubject(request.getLocale()),
                buildConfirmationText(request)
            );
            log.info("Confirmation email sent to {} for contact request {}",
                request.getEmail(), request.getId());
        } catch (Exception e) {
            log.error("Failed to send confirmation email for contact request {}: {}",
                request.getId(), e.getMessage());
        }
    }

    /**
     * Send email via Resend HTTP API (port 443 - always available on cloud).
     */
    private void sendViaResend(String to, String subject, String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(resendApiKey);

        Map<String, Object> body = Map.of(
            "from", fromEmail,
            "to", List.of(to),
            "subject", subject,
            "text", text
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

    private String buildConfirmationText(ContactRequest request) {
        boolean isEnglish = "en".equals(request.getLocale());

        if (isEnglish) {
            return String.format("""
                Hello %s,

                Thank you for contacting GENERATIVA!

                We have received your message and will get back to you within 24 hours.

                Your message:
                "%s"

                Best regards,
                The GENERATIVA Team

                ---
                Website: https://generativa.ro
                Email: contact@generativa.ro
                """,
                request.getName(),
                request.getMessage().substring(0, Math.min(200, request.getMessage().length())) + "..."
            );
        } else {
            return String.format("""
                Bună %s,

                Îți mulțumim că ne-ai contactat!

                Am primit mesajul tău și te vom contacta în maxim 24 de ore.

                Mesajul tău:
                "%s"

                Cu drag,
                Echipa GENERATIVA

                ---
                Website: https://generativa.ro
                Email: contact@generativa.ro
                """,
                request.getName(),
                request.getMessage().substring(0, Math.min(200, request.getMessage().length())) + "..."
            );
        }
    }
}
