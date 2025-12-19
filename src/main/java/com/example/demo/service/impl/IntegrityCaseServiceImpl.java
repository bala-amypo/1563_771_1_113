package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository caseRepo;
    private final StudentProfileRepository studentRepo;

    public IntegrityCaseServiceImpl(
            IntegrityCaseRepository caseRepo,
            StudentProfileRepository studentRepo) {

        this.caseRepo = caseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return caseRepo.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {
        IntegrityCase c = getCaseById(caseId);
        c.setStatus(status);
        return caseRepo.save(c);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
        return caseRepo.findByStudentProfile(student);
    }

    @Override
    public List<IntegrityCase> getAllCases() {
        return caseRepo.findAll();
    }

    @Override
    public IntegrityCase getCaseById(Long id) {
        return caseRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Case not found"));
    }
}
