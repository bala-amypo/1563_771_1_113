// package com.example.demo.controller;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// import com.example.demo.entity.PenaltyAction;
// import com.example.demo.service.PenaltyActionService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/penalties")
// @Tag(name = "Penalty Actions")
// @SecurityRequirement(name = "bearerAuth")
// public class PenaltyActionController {
//     private final PenaltyActionService service;

//     public PenaltyActionController(PenaltyActionService service) {
//         this.service = service;
//     }

//     @PostMapping
//     @Operation(summary = "Add penalty")
//     public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction p) {
//         return ResponseEntity.ok(service.addPenalty(p));
//     }
// }





package com.example.demo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalties")
@Tag(name = "Penalty Actions")
@SecurityRequirement(name = "bearerAuth")
public class PenaltyActionController {

    private final PenaltyActionService service;

    public PenaltyActionController(PenaltyActionService service) {
        this.service = service;
    }

    // POST /api/penalties
    @PostMapping
    @Operation(summary = "Add penalty")
    public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction p) {
        return ResponseEntity.ok(service.addPenalty(p));
    }

    // GET /api/penalties
    @GetMapping
    @Operation(summary = "List all penalties")
    public ResponseEntity<List<PenaltyAction>> getAllPenalties() {
        return ResponseEntity.ok(service.getAllPenalties());
    }

    // GET /api/penalties/{id}
    @GetMapping("/{id}")
    @Operation(summary = "Get penalty by ID")
    public ResponseEntity<PenaltyAction> getPenaltyById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPenaltyById(id));
    }

    // GET /api/penalties/case/{caseId}
    @GetMapping("/case/{caseId}")
    @Operation(summary = "Get penalties for a case")
    public ResponseEntity<List<PenaltyAction>> getPenaltiesByCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(service.getPenaltiesByCase(caseId));
    }
}
