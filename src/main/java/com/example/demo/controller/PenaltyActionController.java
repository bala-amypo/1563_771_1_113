package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@RequestMapping("/api/penalties")
@Tag(name = "Penalty Actions")
@SecurityRequirement(name = "bearerAuth")
public class PenaltyActionController {
    private final PenaltyActionService service;

    public PenaltyActionController(PenaltyActionService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Add penalty")
    public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction p) {
        return ResponseEntity.ok(service.addPenalty(p));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PenaltyAction> getPenaltyActionById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                penaltyActionService.getPenaltyActionById(id)
        );
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<PenaltyAction>> getPenaltyActionsByCaseId(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                penaltyActionService.getPenaltyActionsByCaseId(caseId)
        );
    }

    @GetMapping
    public ResponseEntity<List<PenaltyAction>> getAllPenaltyActions() {
        return ResponseEntity.ok(
                penaltyActionService.getAllPenaltyActions()
        );
    }
}