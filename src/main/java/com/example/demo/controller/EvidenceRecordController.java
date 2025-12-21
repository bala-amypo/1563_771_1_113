package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;

// REMOVED: import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<EvidenceRecord> createEvidence(
            @RequestBody EvidenceRecord evidenceRecord) {

        EvidenceRecord saved =
                evidenceRecordService.createEvidenceRecord(evidenceRecord);

        // ALTERNATIVE: Using .status(201) instead of HttpStatus.CREATED
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvidenceRecord> getEvidenceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceRecordById(id)
        );
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<EvidenceRecord>> getEvidenceByCaseId(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceRecordsByCaseId(caseId)
        );
    }

    @GetMapping
    public ResponseEntity<List<EvidenceRecord>> getAllEvidence() {
        return ResponseEntity.ok(
                evidenceRecordService.getAllEvidenceRecords()
        );
    }
}