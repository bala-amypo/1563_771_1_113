package com.example.demo.service;

import com.example.demo.entity.IntegrityCase;
import java.util.List;

public interface IntegrityCaseService {

    IntegrityCase createCase(IntegrityCase integrityCase);

    IntegrityCase getCaseById(Long id);

    List<IntegrityCase> getAllCases();

    // ✅ REQUIRED BY CONTROLLER
    List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier);

    // ✅ REQUIRED BY CONTROLLER
    IntegrityCase resolveCase(Long id);
}
