package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl
        implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepository;
    private final IntegrityCaseRepository caseRepository;
    private final RepeatOffenderRecordRepository recordRepository;

    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentRepository,
            IntegrityCaseRepository caseRepository,
            RepeatOffenderRecordRepository recordRepository) {

        this.studentRepository = studentRepository;
        this.caseRepository = caseRepository;
        this.recordRepository = recordRepository;
    }

    @Override
    public RepeatOffenderRecord recalculateForStudent(Long studentId) {

        StudentProfile student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Student not found")
                );

        List<IntegrityCase> cases =
                caseRepository.findByStudentProfile_Id(studentId);

        int totalCases = cases.size();

        String severity;
        if (totalCases <= 1) {
            severity = "LOW";
        } else if (totalCases == 2) {
            severity = "MEDIUM";
        } else {
            severity = "HIGH";
        }

        LocalDate firstIncident = cases.stream()
                .map(IntegrityCase::getIncidentDate)
                .filter(d -> d != null)
                .min(LocalDate::compareTo)
                .orElse(null);

        RepeatOffenderRecord record =
                recordRepository.findByStudentProfile(student)
                        .orElse(new RepeatOffenderRecord());

        record.setStudentProfile(student);
        record.setTotalCases(totalCases);
        record.setFlagSeverity(severity);
        record.setFirstIncidentDate(firstIncident);

        student.setRepeatOffender(totalCases > 1);

        studentRepository.save(student);
        return recordRepository.save(record);
    }

    @Override
    public RepeatOffenderRecord getRecordByStudent(Long studentId) {

        StudentProfile student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Student not found")
                );

        return recordRepository.findByStudentProfile(student)
                .orElseThrow(() ->
                        new IllegalArgumentException("Repeat record not found")
                );
    }
}
