package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository evidenceRecordRepository;
    private IntegrityCaseRepository integrityCaseRepository;

    // ✅ Constructor REQUIRED by test cases
    public EvidenceRecordServiceImpl(EvidenceRecordRepository evidenceRecordRepository) {
        this.evidenceRecordRepository = evidenceRecordRepository;
    }

    // ✅ Constructor used by Spring at runtime
    @Autowired
    public EvidenceRecordServiceImpl(
            EvidenceRecordRepository evidenceRecordRepository,
            IntegrityCaseRepository integrityCaseRepository) {
        this.evidenceRecordRepository = evidenceRecordRepository;
        this.integrityCaseRepository = integrityCaseRepository;
    }

    // service methods here
}

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository repository;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord) {
        return repository.save(evidenceRecord);
    }

    // ✅ ADD THESE IMPLEMENTATIONS
    @Override
    public EvidenceRecord getEvidenceRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EvidenceRecord> getEvidenceRecordsByCaseId(Long caseId) {
        return repository.findByIntegrityCase_Id(caseId);
    }

    @Override
    public List<EvidenceRecord> getAllEvidenceRecords() {
        return repository.findAll();
    }
}
