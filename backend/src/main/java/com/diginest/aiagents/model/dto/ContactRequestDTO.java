package com.diginest.aiagents.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO for contact form submissions.
 *
 * Includes validation rules for all fields.
 */
public record ContactRequestDTO(

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name,

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 255, message = "Email must be at most 255 characters")
    String email,

    @NotBlank(message = "Company is required")
    @Size(min = 2, max = 200, message = "Company name must be between 2 and 200 characters")
    String company,

    @Size(max = 20, message = "Phone must be at most 20 characters")
    String phone,

    @NotBlank(message = "Message is required")
    @Size(min = 10, max = 2000, message = "Message must be between 10 and 2000 characters")
    String message,

    // Optional: source tracking
    String source,

    // Optional: locale (ro/en)
    String locale

) {
    /**
     * Create with defaults for optional fields.
     */
    public ContactRequestDTO {
        if (source == null) source = "website";
        if (locale == null) locale = "ro";
    }
}
