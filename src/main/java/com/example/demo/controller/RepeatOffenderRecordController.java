package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    // PUT /api/repeat-offenders/refresh/{studentId}
    @PutMapping("/refresh/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> refresh(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.refreshRepeatOffenderData(studentId));
    }

    // GET /api/repeat-offenders/student/{studentId}
    @GetMapping("/student/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getRecordByStudent(studentId));
    }

    // GET /api/repeat-offenders
    @GetMapping
    public ResponseEntity<List<RepeatOffenderRecord>> getAll() {
        return ResponseEntity.ok(service.getAllRepeatOffenders());
    }
}
