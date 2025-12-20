package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/integrity-cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(
            @RequestBody IntegrityCase integrityCase) {

        return new ResponseEntity<>(
                integrityCaseService.createCase(integrityCase),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(
                integrityCaseService.getCaseById(id)
        );
    }

    @GetMapping("/student/{studentIdentifier}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(
            @PathVariable String studentIdentifier) {

        return ResponseEntity.ok(
                integrityCaseService.getCasesByStudentIdentifier(studentIdentifier)
        );
    }

    // ✅ PUT WITH REQUEST BODY (EDIT SPACE VISIBLE IN SWAGGER)
    @PutMapping("/{id}/resolve")
    public ResponseEntity<IntegrityCase> resolveCase(
            @PathVariable Long id,
            @RequestBody IntegrityCase ignoredBody) {

        // RequestBody is ONLY for Swagger UI
        return ResponseEntity.ok(
                integrityCaseService.resolveCase(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<IntegrityCase>> getAllCases() {
        return ResponseEntity.ok(
                integrityCaseService.getAllCases()
        );
    }
}
