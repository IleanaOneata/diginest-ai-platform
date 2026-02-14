package com.diginest.aiagents.model.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO for demo request form submissions.
 *
 * Captures business details for preparing a personalized AI agent demo.
 */
public record DemoRequestDTO(

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name,

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 255, message = "Email must be at most 255 characters")
    String email,

    @NotBlank(message = "Phone is required")
    @Size(max = 20, message = "Phone must be at most 20 characters")
    String phone,

    @NotBlank(message = "Company is required")
    @Size(min = 2, max = 200, message = "Company name must be between 2 and 200 characters")
    String company,

    @NotBlank(message = "Industry is required")
    @Size(max = 100, message = "Industry must be at most 100 characters")
    String industry,

    @NotBlank(message = "Problem is required")
    @Size(max = 200, message = "Problem must be at most 200 characters")
    String problem,

    @Size(max = 2000, message = "Details must be at most 2000 characters")
    String details,

    // GDPR consent — must be true to process personal data (GDPR Art. 6(1)(a))
    @AssertTrue(message = "GDPR consent is required")
    boolean gdprConsent,

    // Optional: source tracking
    String source,

    // Optional: locale (ro/en)
    String locale

) {
    /**
     * Create with defaults for optional fields.
     */
    public DemoRequestDTO {
        if (source == null) source = "website";
        if (locale == null) locale = "ro";
    }
}
