package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private StudentProfileRepository studentProfileRepository;
    private IntegrityCaseRepository integrityCaseRepository;
    private RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private RepeatOffenderCalculator calculator;

    // ✅ Default constructor (REQUIRED by tests)
    public RepeatOffenderRecordServiceImpl() {
    }

    // ✅ Constructor expected by test cases
    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentProfileRepository,
            IntegrityCaseRepository integrityCaseRepository,
            RepeatOffenderRecordRepository repeatOffenderRecordRepository,
            RepeatOffenderCalculator calculator) {

        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.calculator = calculator;
    }

    @Override
    public RepeatOffenderRecord refreshRepeatOffenderStatus(Long studentId) {

        Optional<StudentProfile> studentOpt = studentProfileRepository.findById(studentId);
        if (studentOpt.isEmpty()) {
            return null;
        }

        StudentProfile student = studentOpt.get();
        List<IntegrityCase> cases =
                integrityCaseRepository.findByStudentProfile_Id(studentId);

        RepeatOffenderRecord record =
                calculator.computeRepeatOffenderRecord(student, cases);

        return repeatOffenderRecordRepository.save(record);
    }

    @Override
    public RepeatOffenderRecord getByStudentId(Long studentId) {
        return repeatOffenderRecordRepository.findByStudentProfile_Id(studentId);
    }

    @Override
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return repeatOffenderRecordRepository.findAll();
    }

    // ✅ Getters & Setters (tests use them)

    public StudentProfileRepository getStudentProfileRepository() {
        return studentProfileRepository;
    }

    public void setStudentProfileRepository(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    public IntegrityCaseRepository getIntegrityCaseRepository() {
        return integrityCaseRepository;
    }

    public void setIntegrityCaseRepository(IntegrityCaseRepository integrityCaseRepository) {
        this.integrityCaseRepository = integrityCaseRepository;
    }

    public RepeatOffenderRecordRepository getRepeatOffenderRecordRepository() {
        return repeatOffenderRecordRepository;
    }

    public void setRepeatOffenderRecordRepository(
            RepeatOffenderRecordRepository repeatOffenderRecordRepository) {
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
    }

    public RepeatOffenderCalculator getCalculator() {
        return calculator;
    }

    public void setCalculator(RepeatOffenderCalculator calculator) {
        this.calculator = calculator;
    }
}
