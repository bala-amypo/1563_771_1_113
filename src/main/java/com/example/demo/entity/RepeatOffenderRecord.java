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

    // 🔗 Link to StudentProfile
    @ManyToOne
    private StudentProfile studentProfile;

    private int repeatCount;

    private String flagSeverity;

    private boolean active;

    // ✅ No-args constructor (REQUIRED by JPA)
    public RepeatOffenderRecord() {
    }

    // ✅ All-args constructor (used by tests / logic)
    public RepeatOffenderRecord(StudentProfile studentProfile,
                                int repeatCount,
                                String flagSeverity,
                                boolean active) {
        this.studentProfile = studentProfile;
        this.repeatCount = repeatCount;
        this.flagSeverity = flagSeverity;
        this.active = active;
    }

    // ✅ Getters and Setters

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

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public String getFlagSeverity() {
        return flagSeverity;
    }

    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
