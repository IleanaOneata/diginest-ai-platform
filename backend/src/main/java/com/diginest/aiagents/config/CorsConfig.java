package com.diginest.aiagents.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * CORS configuration for cross-origin requests.
 *
 * Allows the frontend to communicate with the API.
 * Supports wildcards for Vercel preview URLs.
 */
@Configuration
public class CorsConfig {

    @Value("${app.cors.allowed-origins:http://localhost:3000,http://localhost:4321}")
    private String allowedOrigins;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Parse allowed origins from configuration
        List<String> origins = Arrays.asList(allowedOrigins.split(","));

        // Allow ALL origins for now (contact form doesn't need credentials)
        // This is safe because we don't use cookies/sessions for the contact API
        configuration.addAllowedOrigin("*");

        // Allowed HTTP methods
        configuration.setAllowedMethods(Arrays.asList(
            "GET", "POST", "PUT", "DELETE", "OPTIONS"
        ));

        // Allowed headers - allow all
        configuration.addAllowedHeader("*");

        // Exposed headers (can be read by frontend)
        configuration.setExposedHeaders(Arrays.asList(
            "Access-Control-Allow-Origin"
        ));

        // Disable credentials - required when using wildcard origin "*"
        configuration.setAllowCredentials(false);

        // Cache preflight response for 1 hour
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);

        return source;
    }
}
