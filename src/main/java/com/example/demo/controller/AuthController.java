// package com.example.demo.controller;

// import com.example.demo.dto.JwtResponse;
// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.service.AuthService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final AuthService authService;  
//     public AuthController(AuthService authService) {
//         this.authService = authService;
//     }

//     @PostMapping("/register")
//     public void register(@RequestBody RegisterRequest request) {
//         authService.register(request);
//     }

//     @PostMapping("/login")
//     public JwtResponse login(@RequestBody LoginRequest request) {
//         return authService.login(request);
//     }
// }




package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register user")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req) {
        authService.register(req);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(authService.login(req));
    }
}