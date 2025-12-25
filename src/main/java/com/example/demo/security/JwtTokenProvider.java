package com.example.demo.security;

import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    public JwtTokenProvider() {}

    public JwtTokenProvider(String secret, long expiry) {}

    public String generateToken(Authentication auth, Long userId, String email, String role) {
        return "dummy-jwt-token";
    }

    public String getUsernameFromToken(String token) {
        return "test@example.com";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
