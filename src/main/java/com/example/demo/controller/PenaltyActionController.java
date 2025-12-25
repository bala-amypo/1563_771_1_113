package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalty-actions")
public class PenaltyActionController {

    private final PenaltyActionService service;

    public PenaltyActionController(PenaltyActionService service) {
        this.service = service;
    }

    /* ===== ADD PENALTY ===== */
    @PostMapping
    public ResponseEntity<PenaltyAction> addPenalty(
            @RequestBody PenaltyAction penaltyAction) {

        return new ResponseEntity<>(
                service.addPenalty(penaltyAction),
                HttpStatus.CREATED
        );
    }

    /* ===== GET BY ID ===== */
    @GetMapping("/{id}")
    public ResponseEntity<PenaltyAction> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getPenaltyById(id)
        );
    }

    /* ===== GET BY CASE ===== */
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<PenaltyAction>> getByCase(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                service.getPenaltiesByCase(caseId)
        );
    }

    /* ===== GET ALL ===== */
    @GetMapping
    public ResponseEntity<List<PenaltyAction>> getAll() {
        return ResponseEntity.ok(
                service.getAllPenalties()
        );
    }
}
