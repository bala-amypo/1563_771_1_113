package com.example.demo.service.impl;

import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.RegisterRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(
            AppUserRepository appUserRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider) {

        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }

    public void register(RegisterRequest request) {}

    public String login(LoginRequest request) {
        return "token";
    }
}
