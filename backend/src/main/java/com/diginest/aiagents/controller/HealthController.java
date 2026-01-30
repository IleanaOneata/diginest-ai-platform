package com.diginest.aiagents.controller;

import com.diginest.aiagents.model.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

/**
 * Health check endpoints for monitoring and load balancers.
 */
@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    private final Instant startTime = Instant.now();

    /**
     * Basic health check.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> health() {
        Map<String, Object> healthData = Map.of(
            "status", "healthy",
            "service", "diginest-ai-api",
            "version", "1.0.0",
            "uptime", java.time.Duration.between(startTime, Instant.now()).toSeconds() + "s"
        );

        return ResponseEntity.ok(ApiResponse.success(healthData, "Service is healthy"));
    }

    /**
     * Readiness check - indicates if the service is ready to accept traffic.
     */
    @GetMapping("/ready")
    public ResponseEntity<ApiResponse<Void>> ready() {
        // Add checks for database connectivity, external services, etc.
        return ResponseEntity.ok(ApiResponse.success("Service is ready"));
    }

    /**
     * Liveness check - indicates if the service is alive.
     */
    @GetMapping("/live")
    public ResponseEntity<ApiResponse<Void>> live() {
        return ResponseEntity.ok(ApiResponse.success("Service is alive"));
    }
}
