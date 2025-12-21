package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

import org.springframework.stereotype.Service;
// No Transactional import here

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createStudent(StudentProfile studentProfile) {
        // repository.save() is internally transactional
        return repository.save(studentProfile);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id)
                );
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long id) {
        StudentProfile student = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id)
                );

        student.setRepeatOffender(!student.isRepeatOffender());

        // IMPORTANT: Because we removed @Transactional, we MUST call .save() 
        // to push changes to the database manually.
        return repository.save(student);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentProfile getStudentByStudentIdentifier(String studentIdentifier) {
        return repository.findByStudentIdentifier(studentIdentifier)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found with studentIdentifier: " + studentIdentifier
                        )
                );
    }
}