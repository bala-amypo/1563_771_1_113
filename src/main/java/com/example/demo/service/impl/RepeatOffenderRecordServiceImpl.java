// package com.example.demo.service.impl;

// import com.example.demo.repository.*;
// import com.example.demo.service.RepeatOffenderRecordService;
// import com.example.demo.util.RepeatOffenderCalculator;
// import org.springframework.stereotype.Service;

// @Service
// public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
//     public RepeatOffenderRecordServiceImpl(StudentProfileRepository spr, IntegrityCaseRepository icr,
//                                            RepeatOffenderRecordRepository rorr, RepeatOffenderCalculator roc) {
//         // Constructor matching test instantiation
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;
    private final RepeatOffenderCalculator calculator;

    // ⚠️ DO NOT CHANGE this constructor
    public RepeatOffenderRecordServiceImpl(StudentProfileRepository spr,
                                           IntegrityCaseRepository icr,
                                           RepeatOffenderRecordRepository rorr,
                                           RepeatOffenderCalculator roc) {
        this.studentRepo = spr;
        this.caseRepo = icr;
        this.recordRepo = rorr;
        this.calculator = roc;
    }

    @Override
    public RepeatOffenderRecord refreshRepeatOffenderData(Long studentId) {

        StudentProfile student = studentRepo.findById(studentId).orElse(null);
        if (student == null) return null;

        int count = calculator.calculate(studentId);

        RepeatOffenderRecord record =
                recordRepo.findByStudentProfile(student)
                        .orElse(new RepeatOffenderRecord());

        record.setStudentProfile(student);
        record.setRepeatCount(count);
        record.setRepeatOffender(count > 1);

        return recordRepo.save(record);
    }

    @Override
    public RepeatOffenderRecord getRecordByStudent(Long studentId) {

        StudentProfile student = studentRepo.findById(studentId).orElse(null);
        if (student == null) return null;

        return recordRepo.findByStudentProfile(student).orElse(null);
    }

    @Override
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return recordRepo.findAll();
    }
}


