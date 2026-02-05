package com.diginest.aiagents.controller;

import com.diginest.aiagents.config.RateLimitConfig;
import com.diginest.aiagents.exception.RateLimitException;
import com.diginest.aiagents.model.dto.ApiResponse;
import com.diginest.aiagents.model.dto.ContactRequestDTO;
import com.diginest.aiagents.model.entity.ContactRequest;
import com.diginest.aiagents.service.ContactService;
import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * REST Controller for contact form submissions.
 */
@RestController
@RequestMapping("/api/v1/contact")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;
    private final RateLimitConfig rateLimitConfig;

    public ContactController(ContactService contactService, RateLimitConfig rateLimitConfig) {
        this.contactService = contactService;
        this.rateLimitConfig = rateLimitConfig;
    }

    /**
     * Submit a new contact request.
     *
     * @param dto The contact form data
     * @param request The HTTP request (for IP extraction)
     * @return Success response or error
     */
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> submitContact(
            @Valid @RequestBody ContactRequestDTO dto,
            HttpServletRequest request
    ) {
        String clientIp = getClientIp(request);
        log.info("Contact form submission from IP: {}", clientIp);

        // Check rate limit
        Bucket bucket = rateLimitConfig.resolveContactFormBucket(clientIp);
        if (!bucket.tryConsume(1)) {
            log.warn("Rate limit exceeded for IP: {}", clientIp);
            throw new RateLimitException("Too many requests. Please try again later.");
        }

        try {
            ContactRequest saved = contactService.submitContactRequest(dto, clientIp);
            log.info("Contact request {} submitted successfully", saved.getId());

            String message = "en".equals(dto.locale())
                ? "Thank you! We will contact you soon."
                : "Mulțumim! Te vom contacta în curând.";

            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(message));

        } catch (Exception e) {
            log.error("Error processing contact request: {}", e.getMessage(), e);
            String errorMessage = "en".equals(dto.locale())
                ? "An error occurred. Please try again."
                : "A apărut o eroare. Vă rugăm încercați din nou.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(errorMessage));
        }
    }

    /**
     * Extract client IP address, considering proxy headers.
     */
    private String getClientIp(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            // X-Forwarded-For can contain multiple IPs, get the first one
            return xForwardedFor.split(",")[0].trim();
        }

        String xRealIp = request.getHeader("X-Real-IP");
        if (xRealIp != null && !xRealIp.isEmpty()) {
            return xRealIp;
        }

        return request.getRemoteAddr();
    }
}
