package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private StudentProfileRepository studentProfileRepository;

    // ✅ Default constructor (REQUIRED by tests)
    public StudentProfileServiceImpl() {
    }

    // ✅ Constructor expected by tests
    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public StudentProfile save(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public Optional<StudentProfile> findById(Long id) {
        return studentProfileRepository.findById(id);
    }

    @Override
    public List<StudentProfile> findAll() {
        return studentProfileRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        studentProfileRepository.deleteById(id);
    }

    // ✅ Getter
    public StudentProfileRepository getStudentProfileRepository() {
        return studentProfileRepository;
    }

    // ✅ Setter
    public void setStudentProfileRepository(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }
}
