package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Relation with StudentProfile
    @ManyToOne
    private StudentProfile studentProfile;

    // 🔢 Total integrity cases
    private int totalCases;

    // 🔁 Repeat offender flag
    private boolean repeatOffender;

    // ⚠ Severity level
    private String flagSeverity;

    // ✅ Active status
    private boolean active;

    // ================= CONSTRUCTORS =================

    // Required by JPA
    public RepeatOffenderRecord() {
    }

    // Useful constructor
    public RepeatOffenderRecord(StudentProfile studentProfile,
                                int totalCases,
                                boolean repeatOffender,
                                String flagSeverity,
                                boolean active) {
        this.studentProfile = studentProfile;
        this.totalCases = totalCases;
        this.repeatOffender = repeatOffender;
        this.flagSeverity = flagSeverity;
        this.active = active;
    }

    // ================= GETTERS & SETTERS =================

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

    // 🔹 totalCases
    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    // 🔹 repeatOffender
    public boolean isRepeatOffender() {
        return repeatOffender;
    }

    public void setRepeatOffender(boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }

    // 🔹 flagSeverity
    public String getFlagSeverity() {
        return flagSeverity;
    }

    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }

    // 🔹 active
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.
