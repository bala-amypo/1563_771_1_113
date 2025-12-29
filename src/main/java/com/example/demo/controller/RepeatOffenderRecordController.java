// package com.example.demo.controller;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

// import com.example.demo.entity.RepeatOffenderRecord;
// import com.example.demo.service.RepeatOffenderRecordService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/repeat-offenders")
// @SecurityRequirement(name = "bearerAuth")

// public class RepeatOffenderRecordController {

//     private final RepeatOffenderRecordService service;

//     public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
//         this.service = service;
//     }

//     @PostMapping("/refresh/{studentId}")
//     public ResponseEntity<RepeatOffenderRecord> refresh(@PathVariable Long studentId) {
//         return ResponseEntity.ok(service.refreshRepeatOffenderData(studentId));
//     }

//     @GetMapping("/student/{studentId}")
//     public ResponseEntity<RepeatOffenderRecord> getByStudent(@PathVariable Long studentId) {
//         return ResponseEntity.ok(service.getRecordByStudent(studentId));
//     }

//     @GetMapping
//     public ResponseEntity<List<RepeatOffenderRecord>> getAll() {
//         return ResponseEntity.ok(service.getAllRepeatOffenders());
//     }
// }





package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
@Tag(name = "Repeat Offender Records")
@SecurityRequirement(name = "bearerAuth")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    @PostMapping(value = "/refresh/{studentId}", produces = "application/json")
    @Operation(summary = "Refresh repeat offender record")
    public ResponseEntity<RepeatOffenderRecord> refresh(@PathVariable Long studentId) {
        return ResponseEntity.status(201)
                .body(service.refreshRepeatOffenderData(studentId));
    }

    @GetMapping(value = "/student/{studentId}", produces = "application/json")
    @Operation(summary = "Get repeat offender record by student")
    public ResponseEntity<RepeatOffenderRecord> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getRecordByStudent(studentId));
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Get all repeat offenders")
    public ResponseEntity<List<RepeatOffenderRecord>> getAll() {
        return ResponseEntity.ok(service.getAllRepeatOffenders());
    }
}