// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.PenaltyAction;
// import com.example.demo.service.PenaltyActionService;
// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/api/penalties")
// public class PenaltyActionController {

//     @Autowired
//     PenaltyActionService penaltyActionService;

//     @PostMapping
//     public PenaltyAction create(@Valid @RequestBody PenaltyAction penalty) {
//         return penaltyActionService.addPenalty(penalty);
//     }

//     @GetMapping("/case/{caseId}")
//     public List<PenaltyAction> getByCase(@PathVariable Long caseId) {
//         return penaltyActionService.getPenaltiesByCase(caseId);
//     }

//     @GetMapping("/{id}")
//     public PenaltyAction getById(@PathVariable Long id) {
//         return penaltyActionService.getPenaltyById(id);
//     }

//     @GetMapping
//     public List<PenaltyAction> getAll() {
//         return penaltyActionService.getAllPenalties();
//     }
// }