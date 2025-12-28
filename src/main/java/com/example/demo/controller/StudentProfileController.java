// package com.example.demo.controller;

// import com.example.demo.entity.StudentProfile;
// import com.example.demo.service.StudentProfileService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/students")
// public class StudentProfileController {

//     private final StudentProfileService studentProfileService;

//     public StudentProfileController(StudentProfileService studentProfileService) {
//         this.studentProfileService = studentProfileService;
//     }

//     // POST /api/students/ – Create student profile
//     @PostMapping("/")
//     public StudentProfile create(@RequestBody StudentProfile student) {
//         return studentProfileService.createStudent(student);
//     }

//     // GET /api/students/{id} – Get student by ID
//     @GetMapping("/{id}")
//     public StudentProfile getById(@PathVariable Long id) {
//         return studentProfileService.getStudentById(id);
//     }

//     // GET /api/students/ – List all students
//     @GetMapping("/")
//     public List<StudentProfile> getAll() {
//         return studentProfileService.getAllStudents();
//     }

//     // PUT /api/students/{studentId}/repeat-status – Update repeat offender status
//     @PutMapping("/{studentId}/repeat-status")
//     public StudentProfile updateRepeatStatus(@PathVariable Long studentId) {
//         return studentProfileService.updateRepeatOffenderStatus(studentId);
//     }

//     // GET /api/students/lookup/{studentId} – Find by student identifier
//     @GetMapping("/lookup/{studentId}")
//     public List<StudentProfile> lookupByStudentId(@PathVariable String studentId) {
//         // basic example: filter in memory from all students
//         return studentProfileService.getAllStudents().stream()
//                 .filter(s -> studentId.equals(s.getStudentId()))
//                 .toList();
//     }
// }






package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profile")
public class StudentProfileController {
    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create student")
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile student) {
        return ResponseEntity.ok(service.createStudent(student));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping
    @Operation(summary = "Get all students")
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @PutMapping("/{id}/repeat-offender")
    @Operation(summary = "Update repeat offender status")
    public ResponseEntity<StudentProfile> updateRepeatOffenderStatus(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateRepeatOffenderStatus(id));
    }
}