package com.diginest.aiagents.controller;

import com.diginest.aiagents.config.RateLimitConfig;
import com.diginest.aiagents.exception.RateLimitException;
import com.diginest.aiagents.model.dto.ApiResponse;
import com.diginest.aiagents.model.dto.DemoRequestDTO;
import com.diginest.aiagents.model.entity.DemoRequest;
import com.diginest.aiagents.service.DemoService;
import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for demo request form submissions.
 */
@RestController
@RequestMapping("/api/v1/demo")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    private final DemoService demoService;
    private final RateLimitConfig rateLimitConfig;

    public DemoController(DemoService demoService, RateLimitConfig rateLimitConfig) {
        this.demoService = demoService;
        this.rateLimitConfig = rateLimitConfig;
    }

    /**
     * Submit a new demo request.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> submitDemo(
            @Valid @RequestBody DemoRequestDTO dto,
            HttpServletRequest request
    ) {
        String clientIp = getClientIp(request);
        log.info("Demo request submission from IP: {}", clientIp);

        // Check rate limit
        Bucket bucket = rateLimitConfig.resolveDemoFormBucket(clientIp);
        if (!bucket.tryConsume(1)) {
            log.warn("Rate limit exceeded for demo request from IP: {}", clientIp);
            throw new RateLimitException("Too many requests. Please try again later.");
        }

        try {
            DemoRequest saved = demoService.submitDemoRequest(dto, clientIp);
            log.info("Demo request {} submitted successfully", saved.getId());

            String message = "en".equals(dto.locale())
                ? "Thank you! A GENERATIVA consultant will contact you within 24 hours to schedule your demo."
                : "Mul\u021bumim! Un consultant GENERATIVA te va contacta \u00een maximum 24 de ore pentru programarea demo-ului.";

            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(message));

        } catch (Exception e) {
            log.error("Error processing demo request: {}", e.getMessage(), e);
            String errorMessage = "en".equals(dto.locale())
                ? "An error occurred. Please try again."
                : "A ap\u0103rut o eroare. V\u0103 rug\u0103m \u00eencerca\u021bi din nou.";
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
            return xForwardedFor.split(",")[0].trim();
        }

        String xRealIp = request.getHeader("X-Real-IP");
        if (xRealIp != null && !xRealIp.isEmpty()) {
            return xRealIp;
        }

        return request.getRemoteAddr();
    }
}
