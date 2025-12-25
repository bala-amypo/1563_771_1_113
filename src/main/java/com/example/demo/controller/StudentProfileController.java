package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public StudentProfile createStudent(
            @RequestBody StudentProfile studentProfile) {
        return service.createStudent(studentProfile);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public StudentProfile getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // GET ALL
    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return service.getAllStudents();
    }

    // UPDATE REPEAT OFFENDER
    @PutMapping("/repeat/{id}")
    public StudentProfile markRepeatOffender(@PathVariable Long id) {
        return service.updateRepeatOffenderStatus(id);
    }
}
