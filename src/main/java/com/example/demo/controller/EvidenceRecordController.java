package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceRecordService;

    public EvidenceRecordController(EvidenceRecordService evidenceRecordService) {
        this.evidenceRecordService = evidenceRecordService;
    }

    @PostMapping
    public ResponseEntity<EvidenceRecord> addEvidence(
            @RequestBody EvidenceRecord evidenceRecord) {

        return new ResponseEntity<>(
                evidenceRecordService.addEvidence(evidenceRecord),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvidenceRecord> getEvidenceById(@PathVariable Long id) {
        return ResponseEntity.ok(evidenceRecordService.getEvidenceById(id));
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<EvidenceRecord>> getEvidenceByCase(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceByCaseId(caseId)
        );
    }

    @GetMapping
    public ResponseEntity<List<EvidenceRecord>> getAllEvidence() {
        return ResponseEntity.ok(evidenceRecordService.getAllEvidence());
    }
}
