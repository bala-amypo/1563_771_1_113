package com.example.demo.service.impl;

import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(AppUserRepository appUserRepository,
                           RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }
}
