package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence-records")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceRecordService;

    public EvidenceRecordController(EvidenceRecordService evidenceRecordService) {
        this.evidenceRecordService = evidenceRecordService;
    }

    /* ===== CREATE EVIDENCE RECORD ===== */
    @PostMapping
    public ResponseEntity<EvidenceRecord> createEvidence(
            @RequestBody EvidenceRecord evidenceRecord) {

        EvidenceRecord saved =
                evidenceRecordService.createEvidenceRecord(evidenceRecord);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /* ===== GET EVIDENCE BY ID ===== */
    @GetMapping("/{id}")
    public ResponseEntity<EvidenceRecord> getEvidenceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceRecordById(id)
        );
    }

    /* ===== GET EVIDENCE BY CASE ID (✅ REQUIRED) ===== */
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<EvidenceRecord>> getEvidenceByCaseId(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceRecordsByCaseId(caseId)
        );
    }

    /* ===== GET ALL EVIDENCE RECORDS ===== */
    @GetMapping
    public ResponseEntity<List<EvidenceRecord>> getAllEvidence() {
        return ResponseEntity.ok(
                evidenceRecordService.getAllEvidenceRecords()
        );
    }
}
