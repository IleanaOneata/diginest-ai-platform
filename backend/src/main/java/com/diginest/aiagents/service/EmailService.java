package com.diginest.aiagents.service;

import com.diginest.aiagents.model.entity.ContactRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Service for sending emails.
 *
 * TODO: In production, use HTML templates with Thymeleaf or similar.
 */
@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Value("${app.email.from:contact@generativa.ro}")
    private String fromEmail;

    @Value("${app.email.admin:contact@generativa.ro}")
    private String adminEmail;

    @Value("${app.email.enabled:false}")
    private boolean emailEnabled;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Send notification to admin about new contact request.
     */
    public void sendContactNotification(ContactRequest request) {
        log.info("Email enabled status: {}", emailEnabled);
        if (!emailEnabled) {
            log.info("Email disabled - skipping admin notification for contact request {}", request.getId());
            return;
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(adminEmail);
            message.setSubject("[GENERATIVA] New Contact Request from " + request.getCompany());
            message.setText(buildAdminNotificationText(request));

            mailSender.send(message);
            log.info("Admin notification sent for contact request {}", request.getId());
        } catch (Exception e) {
            log.error("Failed to send admin notification: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Send confirmation email to the user who submitted the contact form.
     */
    public void sendContactConfirmation(ContactRequest request) {
        if (!emailEnabled) {
            log.info("Email disabled - skipping confirmation for contact request {}", request.getId());
            return;
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(request.getEmail());
            message.setSubject(getConfirmationSubject(request.getLocale()));
            message.setText(buildConfirmationText(request));

            mailSender.send(message);
            log.info("Confirmation email sent to {} for contact request {}",
                request.getEmail(), request.getId());
        } catch (Exception e) {
            log.error("Failed to send confirmation email: {}", e.getMessage());
            throw e;
        }
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
