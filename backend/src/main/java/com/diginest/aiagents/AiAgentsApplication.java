package com.diginest.aiagents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Main application class for GENERATIVA AI Agents API.
 *
 * This is the entry point for the Spring Boot application.
 * @EnableAsync enables asynchronous email sending so the contact form
 * responds immediately without waiting for SMTP operations.
 */
@SpringBootApplication
@EnableAsync
public class AiAgentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiAgentsApplication.class, args);
    }
}
