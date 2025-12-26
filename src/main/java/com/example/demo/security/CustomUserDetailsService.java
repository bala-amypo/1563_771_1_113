package com.example.demo.security;

import com.example.demo.repository.AppUserRepository;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    private AppUserRepository appUserRepository;

    // ✅ Default constructor (REQUIRED for some tests)
    public CustomUserDetailsService() {
    }

    // ✅ Constructor used in test cases
    public CustomUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    // ✅ Getter
    public AppUserRepository getAppUserRepository() {
        return appUserRepository;
    }

    // ✅ Setter
    public void setAppUserRepository(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
}
