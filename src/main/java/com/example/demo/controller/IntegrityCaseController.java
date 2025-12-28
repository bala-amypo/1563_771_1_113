// package com.example.demo.controller;

// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.service.IntegrityCaseService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/cases")
// public class IntegrityCaseController {

//     private final IntegrityCaseService integrityCaseService;

//     public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
//         this.integrityCaseService = integrityCaseService;
//     }

//     // POST /api/cases/ – Create new integrity case
//     @PostMapping("/")
//     public IntegrityCase create(@RequestBody IntegrityCase integrityCase) {
//         return integrityCaseService.createCase(integrityCase);
//     }

//     // PUT /api/cases/{id}/status – Update case status
//     @PutMapping("/{id}/status")
//     public IntegrityCase updateStatus(@PathVariable Long id,
//                                       @RequestParam String status) {
//         return integrityCaseService.updateCaseStatus(id, status);
//     }

//     // GET /api/cases/student/{studentId} – Get cases by student
//     @GetMapping("/student/{studentId}")
//     public List<IntegrityCase> getByStudent(@PathVariable Long studentId) {
//         return integrityCaseService.getCasesByStudent(studentId);
//     }

//     // GET /api/cases/{id} – Get case by ID
//     @GetMapping("/{id}")
//     public Optional<IntegrityCase> getById(@PathVariable Long id) {
//         return integrityCaseService.getCaseById(id);
//     }

//     // GET /api/cases/ – List all cases
//     @GetMapping("/")
//     public List<IntegrityCase> getAll() {
//         // simple: aggregate from repository via service
//         return integrityCaseService.getCasesByStudent(null); // adapt if you add getAllCases()
//     }
// }




package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cases")
@Tag(name = "Integrity Cases")
public class IntegrityCaseController {
    private final IntegrityCaseService service;

    public IntegrityCaseController(IntegrityCaseService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create integrity case")
    public ResponseEntity<IntegrityCase> createCase(@RequestBody IntegrityCase c) {
        return ResponseEntity.ok(service.createCase(c));
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update case status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateCaseStatus(id, status));
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get cases by student")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getCasesByStudent(studentId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get case by ID")
    public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
        return service.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
