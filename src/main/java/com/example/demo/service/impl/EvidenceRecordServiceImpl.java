package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository evidenceRepo;
    private final IntegrityCaseRepository caseRepo;

    public EvidenceRecordServiceImpl(
            EvidenceRecordRepository evidenceRepo,
            IntegrityCaseRepository caseRepo) {

        this.evidenceRepo = evidenceRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidence) {
        return evidenceRepo.save(evidence);
    }

    @Override
    public List<EvidenceRecord> getEvidenceByCase(Long caseId) {
        return evidenceRepo.findByIntegrityCaseId(caseId);
    }

    @Override
    public EvidenceRecord getEvidenceById(Long id) {
        return evidenceRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Evidence not found"));
    }

    @Override
    public List<EvidenceRecord> getAllEvidence() {
        return evidenceRepo.findAll();
    }
}
