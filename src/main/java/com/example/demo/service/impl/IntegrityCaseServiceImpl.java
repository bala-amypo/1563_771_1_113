package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    @Autowired
     IntegrityCaseRepository caseRepository;

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return caseRepository.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {
        IntegrityCase integrityCase = getCaseById(caseId);
        integrityCase.setStatus(status);
        return caseRepository.save(integrityCase);
    }

    @Override
public List<IntegrityCase> getCasesByStudent(Long studentId) {
    
    return caseRepository.findByStudentId(studentId);
}
    @Override
    public List<IntegrityCase> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public IntegrityCase getCaseById(Long id) {
        Optional<IntegrityCase> lis =caseRepository.findById(id);
        return lis.orElse(null);
    }
}