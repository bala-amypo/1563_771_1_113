package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
@Service
public class StudentProfileServiceImpl implements StudentProfileService {
@Autowired
private StudentProfileRepository studentRepository;
@Override
public StudentProfile createStudent(StudentProfile dto) {
return studentRepository.save(dto);
}
@Override
public StudentProfile getStudentById(Long id) {
return studentRepository.findById(id)
.orElseThrow(() -> new RuntimeException("Student not found"));
}

@Override
public List<StudentProfile> getAllStudents() {
return studentRepository.findAll();
}

@Override
public StudentProfile updateRepeatOffenderStatus(Long studentId) {
StudentProfile student = getStudentById(studentId);
student.setIsRepeatOffender(true);
return studentRepository.save(student);
}
}


package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentProfile;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile,Long> {


}



package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

@Autowired
StudentProfileService studentProfileService;

@PostMapping
public StudentProfile create(@Valid @RequestBody StudentProfile student) {
return studentProfileService.createStudent(student);
}

@GetMapping("/{id}")
public StudentProfile getbyid(@PathVariable Long id) {
return studentProfileService.getStudentById(id);
}

@GetMapping
public List<StudentProfile> getall() {
return studentProfileService.getAllStudents();
}

@PutMapping("/{id}/repeat-status")
public ResponseEntity<String> updateRepeatStatus(@PathVariable Long id) {
studentProfileService.updateRepeatOffenderStatus(id);
return ResponseEntity.ok("Repeat status updated");
}

@GetMapping("/lookup/{studentId}")
public StudentProfile findByStudentId(@PathVariable Long studentId) {
return studentProfileService.getStudentById(studentId);
}
}