package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(
            RepeatOffenderRecordService service) {
        this.service = service;
    }

    /* ===== RECALCULATE STATUS ===== */
    @PostMapping("/refresh/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> recalculate(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                service.recalculateForStudent(studentId)
        );
    }

    /* ===== GET BY STUDENT ===== */
    @GetMapping("/student/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> getByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                service.getRecordByStudent(studentId)
        );
    }
}
