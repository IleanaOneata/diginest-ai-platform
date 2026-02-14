package com.diginest.aiagents;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Smoke test — verifies Spring context loads successfully.
 * Uses H2 in-memory database (dev profile).
 */
@SpringBootTest
@ActiveProfiles("dev")
class AiAgentsApplicationTest {

    @Test
    @DisplayName("Application context loads successfully")
    void contextLoads() {
        // If this test passes, Spring Boot context wiring is correct:
        // - All beans are resolved
        // - Database connection works (H2 in dev)
        // - @EnableAsync config is valid
        // - SecurityConfig builds successfully
    }
}
