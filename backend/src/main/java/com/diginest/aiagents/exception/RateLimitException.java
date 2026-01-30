package com.diginest.aiagents.exception;

/**
 * Exception thrown when rate limit is exceeded.
 */
public class RateLimitException extends RuntimeException {

    public RateLimitException(String message) {
        super(message);
    }
}
