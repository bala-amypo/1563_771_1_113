package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile studentProfile,
            List<IntegrityCase> cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(studentProfile);
        record.setRepeatOffender(cases != null && cases.size() > 1);
        return record;
    }
}
