package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    private boolean repeatOffender;

    private String flagSeverity;

    // ✅ Default constructor (REQUIRED)
    public RepeatOffenderRecord() {
    }

    // -------- Getters & Setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public boolean isRepeatOffender() {
        return repeatOffender;
    }

    // ✅ REQUIRED by RepeatOffenderRecordServiceImpl
    public void setRepeatOffender(boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }

    public String getFlagSeverity() {
        return flagSeverity;
    }

    // ✅ REQUIRED by RepeatOffenderCalculator
    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }
}
