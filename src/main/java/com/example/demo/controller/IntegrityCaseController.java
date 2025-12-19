// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import jakarta.validation.Valid;

// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.service.IntegrityCaseService;


// @RestController
// @RequestMapping("/api/cases")
// public class IntegrityCaseController {

//     @Autowired
//     IntegrityCaseService integrityCaseService;

//     @PostMapping
//     public IntegrityCase create(@Valid @RequestBody IntegrityCase integrityCase) {
//         return integrityCaseService.createCase(integrityCase);
//     }

//     @PutMapping("/{id}/status")
//     public ResponseEntity<String> updateCaseStatus(@PathVariable Long id) {
//         integrityCaseService.updateCaseStatus(id, null);
//         return ResponseEntity.ok("Case status updated");
//     }

//     @GetMapping("/student/{studentId}")
//     public List<IntegrityCase> getByStudent(@PathVariable Long studentId) {
//         return integrityCaseService.getCasesByStudent(studentId);
//     }

//     @GetMapping("/{id}")
//     public IntegrityCase getById(@PathVariable Long id) {
//         return integrityCaseService.getCaseById(id);
//     }

//     @GetMapping
//     public List<IntegrityCase> getAll() {
//         return integrityCaseService.getAllCases();
//     }
// }