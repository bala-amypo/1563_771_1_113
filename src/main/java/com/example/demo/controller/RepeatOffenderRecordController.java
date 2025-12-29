package com.example.demo.controller;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
@SecurityRequirement(name = "bearerAuth")

public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    @PostMapping("/refresh/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> refresh(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.refreshRepeatOffenderData(studentId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getRecordByStudent(studentId));
    }

    @GetMapping
    public ResponseEntity<List<RepeatOffenderRecord>> getAll() {
        return ResponseEntity.ok(service.getAllRepeatOffenders());
    }
}
