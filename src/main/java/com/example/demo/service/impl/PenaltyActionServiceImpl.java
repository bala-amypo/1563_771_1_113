package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.PenaltyActionService;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyRepo;
    private final IntegrityCaseRepository caseRepo;

    public PenaltyActionServiceImpl(
            PenaltyActionRepository penaltyRepo,
            IntegrityCaseRepository caseRepo) {

        this.penaltyRepo = penaltyRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        return penaltyRepo.save(penalty);
    }

    @Override
    public List<PenaltyAction> getPenaltiesByCase(Long caseId) {
        return penaltyRepo.findByIntegrityCaseId(caseId);
    }

    @Override
    public PenaltyAction getPenaltyById(Long id) {
        return penaltyRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Penalty not found"));
    }

    @Override
    public List<PenaltyAction> getAllPenalties() {
        return penaltyRepo.findAll();
    }
}
