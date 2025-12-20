package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional   // 🔴 VERY IMPORTANT
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository repository;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        integrityCase.setStatus("OPEN");
        return repository.save(integrityCase);
    }

    @Override
    public IntegrityCase getCaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found"));
    }

    @Override
    public List<IntegrityCase> getAllCases() {
        return repository.findAll();
    }

    @Override
    public List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier) {
        return repository.findByStudentIdentifier(studentIdentifier);
    }

    @Override
    public IntegrityCase resolveCase(Long id) {

        // Managed entity inside transaction
        IntegrityCase c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found"));

        c.setStatus("RESOLVED");

        // No save() required — JPA dirty checking updates DB
        return c;
    }
}
