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
     * Saves to database synchronously (fast), then fires async emails.
     * The HTTP response returns immediately after DB save (~50ms).
     * Email sending happens in background threads via @Async in EmailService.
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

        // Save to database (synchronous - fast)
        ContactRequest saved = contactRepository.save(request);
        log.info("Contact request saved with ID: {}", saved.getId());

        // Fire async emails + mark as processed - runs in background thread
        // and does NOT block the HTTP response.
        // Errors are handled inside EmailService (logged, not propagated).
        emailService.sendAllEmails(saved);

        return saved;
    }

    /**
     * Clean up user input: trim whitespace only.
     *
     * Raw data is stored in DB — HTML escaping happens at the output layer
     * (EmailService.escapeHtml()) to prevent double-encoding.
     *
     * Safety: @Valid on DTOs validates at API boundary. JPA uses parameterized
     * queries (no SQL injection). XSS is handled at rendering time.
     */
    private String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return input.trim();
    }
}
