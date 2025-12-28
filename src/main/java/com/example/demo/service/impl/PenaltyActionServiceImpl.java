// package com.example.demo.service.impl;

// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.entity.PenaltyAction;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.IntegrityCaseRepository;
// import com.example.demo.repository.PenaltyActionRepository;
// import com.example.demo.service.PenaltyActionService;
// import org.springframework.stereotype.Service;

// @Service
// public class PenaltyActionServiceImpl implements PenaltyActionService {
//     private final PenaltyActionRepository repo;
//     private final IntegrityCaseRepository caseRepo;

//     public PenaltyActionServiceImpl(PenaltyActionRepository repo, IntegrityCaseRepository caseRepo) {
//         this.repo = repo;
//         this.caseRepo = caseRepo;
//     }

//     @Override
//     public PenaltyAction addPenalty(PenaltyAction p) {
//         IntegrityCase c = caseRepo.findById(p.getIntegrityCase().getId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Case not found"));
//         c.setStatus("UNDER_REVIEW");
//         caseRepo.save(c);
//         return repo.save(p);
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository repo;
    private final IntegrityCaseRepository caseRepo;

    public PenaltyActionServiceImpl(PenaltyActionRepository repo,
                                    IntegrityCaseRepository caseRepo) {
        this.repo = repo;
        this.caseRepo = caseRepo;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction p) {
        IntegrityCase c = caseRepo.findById(p.getIntegrityCase().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Case not found"));

        c.setStatus("UNDER_REVIEW");
        caseRepo.save(c);

        return repo.save(p);
    }

    @Override
    public List<PenaltyAction> getAllPenalties() {
        return repo.findAll();
    }

    @Override
    public PenaltyAction getPenaltyById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Penalty not found"));
    }

    @Override
    public List<PenaltyAction> getPenaltiesByCase(Long caseId) {
        return repo.findByIntegrityCaseId(caseId);
    }
}
