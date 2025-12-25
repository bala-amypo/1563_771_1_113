package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    /* ===== CREATE CASE ===== */
    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(
            @RequestBody IntegrityCase integrityCase) {

        return new ResponseEntity<>(
                integrityCaseService.createCase(integrityCase),
                HttpStatus.CREATED
        );
    }

    /* ===== GET CASE BY ID ===== */
    @GetMapping("/{id}")
    public ResponseEntity<IntegrityCase> getCaseById(
            @PathVariable Long id) {

        return integrityCaseService.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* ===== GET CASES BY STUDENT ===== */
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                integrityCaseService.getCasesByStudent(studentId)
        );
    }

    /* ===== UPDATE STATUS ===== */
    @PutMapping("/{id}/status")
    public ResponseEntity<IntegrityCase> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                integrityCaseService.updateCaseStatus(id, status)
        );
    }
}
