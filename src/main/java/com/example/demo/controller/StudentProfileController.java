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

// import com.example.demo.entity.StudentProfile;
// import com.example.demo.service.StudentProfileService;
// import jakarta.validation.Valid;


// @RestController
// @RequestMapping("/api/students")
// public class StudentProfileController {

// @Autowired
// StudentProfileService studentProfileService;

// @PostMapping
// public StudentProfile create(@Valid @RequestBody StudentProfile student) {
// return studentProfileService.createStudent(student);
// }

// @GetMapping("/{id}")
// public StudentProfile getbyid(@PathVariable Long id) {
// return studentProfileService.getStudentById(id);
// }

// @GetMapping
// public List<StudentProfile> getall() {
// return studentProfileService.getAllStudents();
// }

// @PutMapping("/{id}/repeat-status")
// public ResponseEntity<String> updateRepeatStatus(@PathVariable Long id) {
// studentProfileService.updateRepeatOffenderStatus(id);
// return ResponseEntity.ok("Repeat status updated");
// }

// @GetMapping("/lookup/{studentId}")
// public StudentProfile findByStudentId(@PathVariable Long studentId) {
// return studentProfileService.getStudentById(studentId);
// }
// }