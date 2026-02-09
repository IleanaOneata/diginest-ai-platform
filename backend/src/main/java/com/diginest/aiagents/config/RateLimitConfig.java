package com.diginest.aiagents.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Rate limiting configuration using Bucket4j.
 *
 * Protects API endpoints from abuse by limiting requests per IP.
 */
@Configuration
public class RateLimitConfig {

    /**
     * Store buckets per IP address.
     * In production, consider using Redis for distributed rate limiting.
     */
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    /**
     * Rate limit for contact form submissions: 5 requests per hour per IP.
     */
    public Bucket resolveContactFormBucket(String ip) {
        return buckets.computeIfAbsent(ip, this::createContactFormBucket);
    }

    /**
     * Rate limit for newsletter subscriptions: 3 requests per hour per IP.
     */
    public Bucket resolveNewsletterBucket(String ip) {
        return buckets.computeIfAbsent("newsletter:" + ip, this::createNewsletterBucket);
    }

    /**
     * Rate limit for demo form submissions: 3 requests per hour per IP.
     */
    public Bucket resolveDemoFormBucket(String ip) {
        return buckets.computeIfAbsent("demo:" + ip, this::createDemoFormBucket);
    }

    /**
     * General API rate limit: 100 requests per minute per IP.
     */
    public Bucket resolveGeneralBucket(String ip) {
        return buckets.computeIfAbsent("general:" + ip, this::createGeneralBucket);
    }

    private Bucket createContactFormBucket(String key) {
        Bandwidth limit = Bandwidth.builder()
            .capacity(5)
            .refillGreedy(5, Duration.ofHours(1))
            .build();
        return Bucket.builder().addLimit(limit).build();
    }

    private Bucket createNewsletterBucket(String key) {
        Bandwidth limit = Bandwidth.builder()
            .capacity(3)
            .refillGreedy(3, Duration.ofHours(1))
            .build();
        return Bucket.builder().addLimit(limit).build();
    }

    private Bucket createDemoFormBucket(String key) {
        Bandwidth limit = Bandwidth.builder()
            .capacity(3)
            .refillGreedy(3, Duration.ofHours(1))
            .build();
        return Bucket.builder().addLimit(limit).build();
    }

    private Bucket createGeneralBucket(String key) {
        Bandwidth limit = Bandwidth.builder()
            .capacity(100)
            .refillGreedy(100, Duration.ofMinutes(1))
            .build();
        return Bucket.builder().addLimit(limit).build();
    }

    /**
     * Clean up old buckets periodically.
     * In production, this should be scheduled or use Redis with TTL.
     */
    public void cleanupOldBuckets() {
        // Implementation would go here for production
        // For MVP, buckets will accumulate but memory impact is minimal
    }
}
