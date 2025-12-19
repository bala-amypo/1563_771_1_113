package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfile;
@Service
public interface StudentProfileService {
StudentProfile createStudent(StudentProfile dto);
StudentProfile getStudentById(Long id);
List<StudentProfile> getAllStudents();
StudentProfile updateRepeatOffenderStatus(Long StudentId);
}

