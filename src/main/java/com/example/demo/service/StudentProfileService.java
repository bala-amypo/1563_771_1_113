package com.example.Academy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Academy.entity.StudentProfile;
@Service
public interface StudentProfileService {
    StudentProfile createStudent(StudentProfile dto);
    StudentProfile getStudentById(Long id);
    List<StudentProfile> getAllStudent();
    StudentProfile updateRepeatOffenderStatus(Long StudentId);
}
