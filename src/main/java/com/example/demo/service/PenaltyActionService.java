package com.example.demo.service;

import com.example.demo.entity.PenaltyAction;

import java.util.List;

public interface PenaltyActionService {

    PenaltyAction addPenalty(PenaltyAction penaltyAction);

    PenaltyAction getPenaltyById(Long id);

    List<PenaltyAction> getAllPenalties();

    List<PenaltyAction> getPenaltiesByCase(Long caseId);
}
