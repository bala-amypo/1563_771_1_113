// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.StudentProfile;
// import com.example.demo.repository.StudentProfileRepository;
// import com.example.demo.service.StudentProfileService;
// @Service
// public class StudentProfileServiceImpl implements StudentProfileService {
// @Autowired
// private StudentProfileRepository studentRepository;
// @Override
// public StudentProfile createStudent(StudentProfile dto) {
// return studentRepository.save(dto);
// }
// @Override
// public StudentProfile getStudentById(Long id) {
// return studentRepository.findById(id)
// .orElseThrow(() -> new RuntimeException("Student not found"));
// }

// @Override
// public List<StudentProfile> getAllStudents() {
// return studentRepository.findAll();
// }

// @Override
// public StudentProfile updateRepeatOffenderStatus(Long studentId) {
// StudentProfile student = getStudentById(studentId);
// student.setIsRepeatOffender(true);
// return studentRepository.save(student);
// }
// }






