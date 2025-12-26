package com.example.demo.service;

import com.example.demo.entity.EvidenceRecord;

import java.util.List;

public interface EvidenceRecordService {

    // existing method
    EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord);

    // ✅ ADD THESE METHODS
    EvidenceRecord getEvidenceRecordById(Long id);

    List<EvidenceRecord> getEvidenceRecordsByCaseId(Long caseId);

    List<EvidenceRecord> getAllEvidenceRecords();
}
