package com.diginest.aiagents.service;

import com.diginest.aiagents.model.dto.DemoRequestDTO;
import com.diginest.aiagents.model.entity.DemoRequest;
import com.diginest.aiagents.repository.DemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for handling demo request form submissions.
 */
@Service
public class DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoService.class);

    private final DemoRepository demoRepository;
    private final EmailService emailService;

    public DemoService(DemoRepository demoRepository, EmailService emailService) {
        this.demoRepository = demoRepository;
        this.emailService = emailService;
    }

    /**
     * Process a new demo request submission.
     *
     * Saves to database synchronously (fast), then fires async emails.
     * The HTTP response returns immediately after DB save (~50ms).
     * Email sending happens in background threads via @Async in EmailService.
     */
    @Transactional
    public DemoRequest submitDemoRequest(DemoRequestDTO dto, String ipAddress) {
        log.info("Processing demo request from {} (company: {})", dto.email(), dto.company());

        // Create entity from DTO
        DemoRequest request = new DemoRequest(
            sanitize(dto.name()),
            sanitize(dto.email()).toLowerCase(),
            sanitize(dto.phone()),
            sanitize(dto.company()),
            sanitize(dto.industry()),
            sanitize(dto.problem()),
            sanitize(dto.details()),
            dto.gdprConsent(),
            dto.source(),
            dto.locale(),
            ipAddress
        );

        // Save to database (synchronous - fast)
        DemoRequest saved = demoRepository.save(request);
        log.info("Demo request saved with ID: {}", saved.getId());

        // Fire async emails + mark as processed - runs in background thread
        emailService.sendAllDemoEmails(saved);

        return saved;
    }

    /**
     * Sanitize input to prevent XSS and clean up whitespace.
     *
     * IMPORTANT: & must be replaced FIRST, before < and >.
     * Otherwise "&lt;" from step 1 becomes "&amp;lt;" (double-encoding).
     */
    private String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return input.trim()
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#x27;");
    }
}
