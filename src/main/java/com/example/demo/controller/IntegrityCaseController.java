// package com.example.demo.controller;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.service.IntegrityCaseService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/cases")
// @Tag(name = "Integrity Cases")
// @SecurityRequirement(name = "bearerAuth")
// public class IntegrityCaseController {
//     private final IntegrityCaseService service;

//     public IntegrityCaseController(IntegrityCaseService service) {
//         this.service = service;
//     }

//     @PostMapping
//     @Operation(summary = "Create integrity case")
//     public ResponseEntity<IntegrityCase> createCase(@RequestBody IntegrityCase c) {
//         return ResponseEntity.ok(service.createCase(c));
//     }

//     @PutMapping("/{id}/status")
//     @Operation(summary = "Update case status")
//     public ResponseEntity<IntegrityCase> updateCaseStatus(@PathVariable Long id, @RequestParam String status) {
//         return ResponseEntity.ok(service.updateCaseStatus(id, status));
//     }

//     @GetMapping("/student/{studentId}")
//     @Operation(summary = "Get cases by student")
//     public ResponseEntity<List<IntegrityCase>> getCasesByStudent(@PathVariable Long studentId) {
//         return ResponseEntity.ok(service.getCasesByStudent(studentId));
//     }

//     @GetMapping("/{id}")
//     @Operation(summary = "Get case by ID")
//     public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
//         return service.getCaseById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }
// }





package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@Tag(name = "Integrity Cases")
@SecurityRequirement(name = "bearerAuth")
public class IntegrityCaseController {

    private final IntegrityCaseService service;

    public IntegrityCaseController(IntegrityCaseService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @Operation(summary = "Create integrity case")
    public ResponseEntity<IntegrityCase> createCase(@RequestBody IntegrityCase c) {
        return ResponseEntity.status(201).body(service.createCase(c));
    }

    @PutMapping(value = "/{id}/status", produces = "application/json")
    @Operation(summary = "Update case status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(service.updateCaseStatus(id, status));
    }

    @GetMapping(value = "/student/{studentId}", produces = "application/json")
    @Operation(summary = "Get cases by student ID")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getCasesByStudent(studentId));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Get case by ID")
    public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCaseById(id)
                .orElseThrow(() -> new RuntimeException("Case not found")));
    }
}