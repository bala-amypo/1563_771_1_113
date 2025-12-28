// package com.example.demo.controller;

// import com.example.demo.entity.PenaltyAction;
// import com.example.demo.repository.PenaltyActionRepository;
// import com.example.demo.service.PenaltyActionService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/penalties")
// public class PenaltyActionController {

//     private final PenaltyActionService penaltyActionService;
//     private final PenaltyActionRepository penaltyActionRepository;

//     public PenaltyActionController(PenaltyActionService penaltyActionService,
//                                    PenaltyActionRepository penaltyActionRepository) {
//         this.penaltyActionService = penaltyActionService;
//         this.penaltyActionRepository = penaltyActionRepository;
//     }

//     // POST /api/penalties/ – Add penalty
//     @PostMapping("/")
//     public PenaltyAction add(@RequestBody PenaltyAction penaltyAction) {
//         return penaltyActionService.addPenalty(penaltyAction);
//     }

//     // GET /api/penalties/case/{caseId} – Get penalties for case
//     @GetMapping("/case/{caseId}")
//     public List<PenaltyAction> getByCase(@PathVariable Long caseId) {
//         return penaltyActionRepository.findAll().stream()
//                 .filter(p -> p.getIntegrityCase() != null &&
//                              caseId.equals(p.getIntegrityCase().getId()))
//                 .toList();
//     }

//     // GET /api/penalties/{id} – Get penalty by ID
//     @GetMapping("/{id}")
//     public PenaltyAction getById(@PathVariable Long id) {
//         return penaltyActionRepository.findById(id).orElse(null);
//     }

//     // GET /api/penalties/ – List all penalties
//     @GetMapping("/")
//     public List<PenaltyAction> getAll() {
//         return penaltyActionRepository.findAll();
//     }
// }




package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/penalties")
@Tag(name = "Penalty Actions")
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
}