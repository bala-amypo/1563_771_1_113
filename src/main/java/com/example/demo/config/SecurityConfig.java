package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public String dummySecurityBean() {
        // Minimal config just to satisfy compilation
        return "SECURITY_ENABLED";
    }
}
