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

    @PostMapping
    @Operation(summary = "Add penalty")
    public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction p) {
        return ResponseEntity.ok(service.addPenalty(p));
    }

    @GetMapping
    @Operation(summary = "List all penalties")
    public ResponseEntity<List<PenaltyAction>> getAllPenalties() {
        return ResponseEntity.ok(service.getAllPenalties());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get penalty by ID")
    public ResponseEntity<PenaltyAction> getPenaltyById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPenaltyById(id));
    }

    @GetMapping("/case/{caseId}")
    @Operation(summary = "Get penalties for a case")
    public ResponseEntity<List<PenaltyAction>> getPenaltiesByCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(service.getPenaltiesByCase(caseId));
    }
}






// package com.example.demo.controller;

// import com.example.demo.entity.PenaltyAction;
// import com.example.demo.service.PenaltyActionService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/penalties")
// @Tag(name = "Penalty Actions")
// @SecurityRequirement(name = "bearerAuth")
// public class PenaltyActionController {

//     private final PenaltyActionService service;

//     public PenaltyActionController(PenaltyActionService service) {
//         this.service = service;
//     }

//     @PostMapping(consumes = "application/json", produces = "application/json")
//     @Operation(summary = "Add penalty action")
//     public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction p) {
//         return ResponseEntity.status(201).body(service.addPenalty(p));
//     }

//     @GetMapping(produces = "application/json")
//     @Operation(summary = "Get all penalties")
//     public ResponseEntity<List<PenaltyAction>> getAllPenalties() {
//         return ResponseEntity.ok(service.getAllPenalties());
//     }

//     @GetMapping(value = "/{id}", produces = "application/json")
//     @Operation(summary = "Get penalty by ID")
//     public ResponseEntity<PenaltyAction> getPenaltyById(@PathVariable Long id) {
//         return ResponseEntity.ok(service.getPenaltyById(id));
//     }

//     @GetMapping(value = "/case/{caseId}", produces = "application/json")
//     @Operation(summary = "Get penalties by case ID")
//     public ResponseEntity<List<PenaltyAction>> getPenaltiesByCase(@PathVariable Long caseId) {
//         return ResponseEntity.ok(service.getPenaltiesByCase(caseId));
//     }
// }