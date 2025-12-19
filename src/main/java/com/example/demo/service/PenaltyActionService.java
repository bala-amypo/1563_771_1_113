package com.example.Academy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Academy.entity.PenaltyAction;
@Service
public interface PenaltyActionService {
    PenaltyAction addPenalty(PenaltyAction penalty);
    List<PenaltyAction> getPenaltiesByCase(Long caseId);
    PenaltyAction getPenaltyById(Long id);
    List<PenaltyAction> getAllPenalties();
}
