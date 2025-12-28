// package com.example.demo.service;
// import com.example.demo.entity.PenaltyAction;

// public interface PenaltyActionService {
//     PenaltyAction addPenalty(PenaltyAction p);
// }




package com.example.demo.service;

import com.example.demo.entity.PenaltyAction;
import java.util.List;

public interface PenaltyActionService {

    PenaltyAction addPenalty(PenaltyAction p);

    List<PenaltyAction> getAllPenalties();

    PenaltyAction getPenaltyById(Long id);

    List<PenaltyAction> getPenaltiesByCase(Long caseId);
}
