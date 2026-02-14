package com.diginest.aiagents.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Rate limiting configuration using Bucket4j.
 *
 * Protects API endpoints from abuse by limiting requests per IP.
 * Buckets are cleaned up every 2 hours to prevent memory leaks.
 */
@Configuration
public class RateLimitConfig {

    private static final Logger log = LoggerFactory.getLogger(RateLimitConfig.class);

    /**
     * Store buckets per IP address.
     * Cleaned periodically by scheduled task to prevent unbounded growth.
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
     * Clean up all buckets every 2 hours to prevent memory leak.
     * Active IPs will recreate their buckets on next request (cheap operation).
     * Bucket refill timers (1h for forms, 1min for general) are shorter than cleanup interval,
     * so no rate limit state is lost for legitimate users.
     */
    @Scheduled(fixedRate = 7200000) // 2 hours in milliseconds
    public void cleanupOldBuckets() {
        int size = buckets.size();
        if (size > 0) {
            buckets.clear();
            log.info("Rate limit cleanup: cleared {} bucket entries", size);
        }
    }
}
