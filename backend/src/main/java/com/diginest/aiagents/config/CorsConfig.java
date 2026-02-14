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
 * Restricts API access to known frontend origins only.
 * Vercel preview URLs supported via allowedOriginPatterns.
 *
 * IMPORTANT: @CrossOrigin on controllers is REMOVED — this is the single source of truth.
 */
@Configuration
public class CorsConfig {

    @Value("${app.cors.allowed-origins:http://localhost:3000,http://localhost:4321}")
    private String allowedOrigins;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Parse allowed origins from configuration (exact matches)
        List<String> origins = Arrays.asList(allowedOrigins.split(","));
        for (String origin : origins) {
            String trimmed = origin.trim();
            if (trimmed.contains("*")) {
                // Wildcard patterns (e.g., https://*.vercel.app) use allowedOriginPatterns
                configuration.addAllowedOriginPattern(trimmed);
            } else {
                configuration.addAllowedOrigin(trimmed);
            }
        }

        // Allowed HTTP methods — only what we actually need
        configuration.setAllowedMethods(Arrays.asList(
            "GET", "POST", "OPTIONS"
        ));

        // Allowed headers
        configuration.addAllowedHeader("*");

        // No credentials needed (stateless API, no cookies/sessions)
        configuration.setAllowCredentials(false);

        // Cache preflight response for 1 hour
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);

        return source;
    }
}
