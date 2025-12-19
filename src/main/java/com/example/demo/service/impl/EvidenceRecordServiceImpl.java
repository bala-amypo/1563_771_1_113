package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.service.EvidenceRecordService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository repository;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EvidenceRecord createEvidenceRecord(EvidenceRecord evidenceRecord) {
        return repository.save(evidenceRecord);
    }

    @Override
    public EvidenceRecord getEvidenceRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evidence not found"));
    }

    @Override
    public List<EvidenceRecord> getAllEvidenceRecords() {
        return repository.findAll();
    }
}
