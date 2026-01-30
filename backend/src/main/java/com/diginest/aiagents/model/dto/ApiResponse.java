package com.diginest.aiagents.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;

/**
 * Standard API response wrapper.
 *
 * Provides consistent response structure across all endpoints.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
    boolean success,
    String message,
    T data,
    String error,
    Instant timestamp
) {

    /**
     * Create a successful response with data.
     */
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, message, data, null, Instant.now());
    }

    /**
     * Create a successful response without data.
     */
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, message, null, null, Instant.now());
    }

    /**
     * Create an error response.
     */
    public static <T> ApiResponse<T> error(String error, String message) {
        return new ApiResponse<>(false, message, null, error, Instant.now());
    }

    /**
     * Create an error response with just an error message.
     */
    public static <T> ApiResponse<T> error(String error) {
        return new ApiResponse<>(false, null, null, error, Instant.now());
    }
}
