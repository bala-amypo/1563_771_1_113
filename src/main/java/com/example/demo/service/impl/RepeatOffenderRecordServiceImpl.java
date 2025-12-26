package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.RepeatOffenderRecordService;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    // ✅ Default constructor
    public RepeatOffenderRecordServiceImpl() {
    }

    @Override
    public RepeatOffenderRecord createRepeatOffenderRecord(StudentProfile studentProfile) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(studentProfile);
        record.setRepeatOffender(false);
        return record;
    }

    @Override
    public RepeatOffenderRecord getRecordByStudent(Long studentId) {
        return null;
    }
}
