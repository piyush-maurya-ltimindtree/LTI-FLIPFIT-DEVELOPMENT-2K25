package com.flipfit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Security-related beans configuration.
 *
 * @author Mayuresh Arvind Gujar
 */
@Configuration
public class SecurityBeansConfig {

    /**
     * Provides a BCryptPasswordEncoder for hashing and credential verification.
     *
     * @return BCryptPasswordEncoder bean
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
