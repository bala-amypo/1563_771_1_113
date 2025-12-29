// package com.example.demo.service.impl;

// import com.example.demo.entity.EvidenceRecord;
// import com.example.demo.repository.EvidenceRecordRepository;
// import com.example.demo.repository.IntegrityCaseRepository;
// import com.example.demo.service.EvidenceRecordService;
// import org.springframework.stereotype.Service;

// @Service
// public class EvidenceRecordServiceImpl implements EvidenceRecordService {
//     private final EvidenceRecordRepository repo;
//     private final IntegrityCaseRepository caseRepo;

//     public EvidenceRecordServiceImpl(EvidenceRecordRepository repo, IntegrityCaseRepository caseRepo) {
//         this.repo = repo;
//         this.caseRepo = caseRepo;
//     }

//     @Override
//     public EvidenceRecord submitEvidence(EvidenceRecord e) {
//         // Ensure case exists
//         caseRepo.findById(e.getIntegrityCase().getId());
//         return repo.save(e);
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository repo;
    private final IntegrityCaseRepository caseRepo;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository repo,
                                     IntegrityCaseRepository caseRepo) {
        this.repo = repo;
        this.caseRepo = caseRepo;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord e) {
        caseRepo.findById(e.getIntegrityCase().getId());
        return repo.save(e);
    }

    @Override
    public List<EvidenceRecord> getEvidenceByCase(Long caseId) {
        return repo.findAll()
                .stream()
                .filter(er -> er.getIntegrityCase() != null
                        && er.getIntegrityCase().getId().equals(caseId))
                .collect(Collectors.toList());
    }

    @Override
    public EvidenceRecord getEvidenceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EvidenceRecord> getAllEvidence() {
        return repo.findAll();
    }
}



// package com.example.demo.service.impl;

// import com.example.demo.entity.EvidenceRecord;
// import com.example.demo.repository.EvidenceRecordRepository;
// import com.example.demo.repository.IntegrityCaseRepository;
// import com.example.demo.service.EvidenceRecordService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class EvidenceRecordServiceImpl implements EvidenceRecordService {

//     private final EvidenceRecordRepository repo;
//     private final IntegrityCaseRepository caseRepo;

//     public EvidenceRecordServiceImpl(EvidenceRecordRepository repo,
//                                      IntegrityCaseRepository caseRepo) {
//         this.repo = repo;
//         this.caseRepo = caseRepo;
//     }

//     @Override
//     public EvidenceRecord submitEvidence(EvidenceRecord e) {
//         // Ensure case exists (as per your original code)
//         caseRepo.findById(e.getIntegrityCase().getId());
//         return repo.save(e);
//     }

//     @Override
//     public List<EvidenceRecord> getEvidenceByCase(Long caseId) {
//         return repo.findByIntegrityCase_Id(caseId);
//     }

//     @Override
//     public EvidenceRecord getEvidenceById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public List<EvidenceRecord> getAllEvidence() {
//         return repo.findAll();
//     }
// }
