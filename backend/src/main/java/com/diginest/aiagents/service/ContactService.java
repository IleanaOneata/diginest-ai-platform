package com.diginest.aiagents.service;

import com.diginest.aiagents.model.dto.ContactRequestDTO;
import com.diginest.aiagents.model.entity.ContactRequest;
import com.diginest.aiagents.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for handling contact form submissions.
 */
@Service
public class ContactService {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private final ContactRepository contactRepository;
    private final EmailService emailService;

    public ContactService(ContactRepository contactRepository, EmailService emailService) {
        this.contactRepository = contactRepository;
        this.emailService = emailService;
    }

    /**
     * Process a new contact form submission.
     *
     * @param dto The contact request data
     * @param ipAddress The client IP address
     * @return The saved contact request
     */
    @Transactional
    public ContactRequest submitContactRequest(ContactRequestDTO dto, String ipAddress) {
        log.info("Processing contact request from {} (company: {})", dto.email(), dto.company());

        // Create entity from DTO
        ContactRequest request = new ContactRequest(
            sanitize(dto.name()),
            sanitize(dto.email()).toLowerCase(),
            sanitize(dto.company()),
            sanitize(dto.phone()),
            sanitize(dto.message()),
            dto.source(),
            dto.locale(),
            ipAddress
        );

        // Save to database
        ContactRequest saved = contactRepository.save(request);
        log.info("Contact request saved with ID: {}", saved.getId());

        // Send notification email to admin
        try {
            emailService.sendContactNotification(saved);
        } catch (Exception e) {
            log.error("Failed to send notification email for contact request {}: {}",
                saved.getId(), e.getMessage());
            // Don't fail the request if email fails
        }

        // Send confirmation email to user
        try {
            emailService.sendContactConfirmation(saved);
        } catch (Exception e) {
            log.error("Failed to send confirmation email for contact request {}: {}",
                saved.getId(), e.getMessage());
            // Don't fail the request if email fails
        }

        return saved;
    }

    /**
     * Sanitize input to prevent XSS and clean up whitespace.
     */
    private String sanitize(String input) {
        if (input == null) {
            return null;
        }
        // Trim whitespace and basic HTML escaping
        return input.trim()
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("&", "&amp;")
            .replace("\"", "&quot;")
            .replace("'", "&#x27;");
    }
}
