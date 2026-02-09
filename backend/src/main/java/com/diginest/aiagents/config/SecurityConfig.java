package com.diginest.aiagents.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration for the API.
 *
 * Configures:
 * - CORS settings (using CorsConfig bean)
 * - CSRF protection (disabled for stateless API)
 * - Endpoint security rules
 * - Session management (stateless)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Enable CORS using the CorsConfigurationSource bean
            .cors(Customizer.withDefaults())

            // Disable CSRF for stateless API
            .csrf(AbstractHttpConfigurer::disable)

            // Configure session management
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // Configure authorization rules
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers("/api/v1/contact/**").permitAll()
                .requestMatchers("/api/v1/demo/**").permitAll()
                .requestMatchers("/api/v1/newsletter/**").permitAll()
                .requestMatchers("/api/v1/health/**").permitAll()
                .requestMatchers("/actuator/health").permitAll()

                // Secure admin endpoints (when implemented)
                .requestMatchers("/api/v1/admin/**").authenticated()

                // Allow everything else (adjust as needed)
                .anyRequest().permitAll()
            )

            // Configure security headers
            .headers(headers -> headers
                .contentSecurityPolicy(csp ->
                    csp.policyDirectives("default-src 'self'; frame-ancestors 'none';")
                )
                .frameOptions(frame -> frame.deny())
            );

        return http.build();
    }
}
