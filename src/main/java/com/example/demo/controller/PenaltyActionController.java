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

        private final PenaltyActionService penaltyActionService;

        public PenaltyActionController(PenaltyActionService penaltyActionService) {
            this.penaltyActionService = penaltyActionService;
        }

        /* ===== CREATE PENALTY ACTION ===== */
        @PostMapping
        public ResponseEntity<PenaltyAction> createPenaltyAction(
                @RequestBody PenaltyAction penaltyAction) {

            PenaltyAction saved =
                    penaltyActionService.createPenaltyAction(penaltyAction);

            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }

        /* ===== GET PENALTY ACTION BY ID ===== */
        @GetMapping("/{id}")
        public ResponseEntity<PenaltyAction> getPenaltyActionById(
                @PathVariable Long id) {

            return ResponseEntity.ok(
                    penaltyActionService.getPenaltyActionById(id)
            );
        }

        /* ===== GET ALL PENALTY ACTIONS ===== */
        @GetMapping
        public ResponseEntity<List<PenaltyAction>> getAllPenaltyActions() {
            return ResponseEntity.ok(
                    penaltyActionService.getAllPenaltyActions()
            );
        }
    }
