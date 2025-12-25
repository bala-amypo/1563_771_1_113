package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyRepository;
    private final IntegrityCaseRepository caseRepository;

    public PenaltyActionServiceImpl(
            PenaltyActionRepository penaltyRepository,
            IntegrityCaseRepository caseRepository) {

        this.penaltyRepository = penaltyRepository;
        this.caseRepository = caseRepository;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penaltyAction) {

        Long caseId = penaltyAction.getIntegrityCase().getId();

        IntegrityCase integrityCase = caseRepository.findById(caseId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Case not found")
                );

        // 🔥 BUSINESS RULE: Move case to UNDER_REVIEW
        integrityCase.setStatus("UNDER_REVIEW");
        caseRepository.save(integrityCase);

        penaltyAction.setIntegrityCase(integrityCase);
        return penaltyRepository.save(penaltyAction);
    }

    @Override
    public PenaltyAction getPenaltyById(Long id) {
        return penaltyRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Penalty not found")
                );
    }

    @Override
    public List<PenaltyAction> getAllPenalties() {
        return penaltyRepository.findAll();
    }

    @Override
    public List<PenaltyAction> getPenaltiesByCase(Long caseId) {
        return penaltyRepository.findByIntegrityCase_Id(caseId);
    }
}
