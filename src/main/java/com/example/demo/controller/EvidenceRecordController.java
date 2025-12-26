package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@Tag(name = "Evidence Records")
public class EvidenceRecordController {

    private final EvidenceRecordService service;

    public EvidenceRecordController(EvidenceRecordService service) {
        this.service = service;
    }

    /* ===== EXISTING CODE (UNCHANGED) ===== */
    @PostMapping
    @Operation(summary = "Submit evidence")
    public ResponseEntity<EvidenceRecord> submitEvidence(
            @RequestBody EvidenceRecord e) {

        return ResponseEntity.ok(service.submitEvidence(e));
    }

    /* ===== ADDED MAPPINGS ===== */

    /* GET EVIDENCE BY ID */
    @GetMapping("/{id}")
    @Operation(summary = "Get evidence by ID")
    public ResponseEntity<EvidenceRecord> getEvidenceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getEvidenceRecordById(id)
        );
    }

    /* GET EVIDENCE BY CASE ID */
    @GetMapping("/case/{caseId}")
    @Operation(summary = "Get evidence by case ID")
    public ResponseEntity<List<EvidenceRecord>> getEvidenceByCaseId(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                service.getEvidenceRecordsByCaseId(caseId)
        );
    }

    /* GET ALL EVIDENCE */
    @GetMapping
    @Operation(summary = "Get all evidence records")
    public ResponseEntity<List<EvidenceRecord>> getAllEvidence() {

        return ResponseEntity.ok(
                service.getAllEvidenceRecords()
        );
    }
}
