package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository caseRepository;
    private final StudentProfileRepository studentRepository;

    public IntegrityCaseServiceImpl(
            IntegrityCaseRepository caseRepository,
            StudentProfileRepository studentRepository) {

        this.caseRepository = caseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {

        if (integrityCase.getStudentProfile() == null ||
            integrityCase.getStudentProfile().getId() == null) {

            throw new IllegalArgumentException("StudentProfile is required");
        }

        StudentProfile student = studentRepository.findById(
                integrityCase.getStudentProfile().getId()
        ).orElseThrow(() ->
                new IllegalArgumentException("StudentProfile not found")
        );

        integrityCase.setStudentProfile(student);
        return caseRepository.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {

        IntegrityCase c = caseRepository.findById(caseId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Case not found")
                );

        c.setStatus(status);
        return caseRepository.save(c);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return caseRepository.findByStudentProfile_Id(studentId);
    }

    @Override
    public Optional<IntegrityCase> getCaseById(Long caseId) {
        return caseRepository.findById(caseId);
    }
}
