package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "repeat_offender_records")
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // -------------------------
    // Relationships
    // -------------------------
    @OneToOne
    @JoinColumn(name = "student_profile_id", nullable = false)
    private StudentProfile studentProfile;

    // -------------------------
    // Fields
    // -------------------------
    @Column(nullable = false)
    private int totalCases;

    @Column(nullable = false)
    private boolean repeatOffender;

    @Column(length = 20)
    private String flagSeverity;

    // -------------------------
    // Constructors
    // -------------------------

    // REQUIRED by JPA & tests
    public RepeatOffenderRecord() {
    }

    // OPTIONAL convenience constructor
    public RepeatOffenderRecord(StudentProfile studentProfile,
                                int totalCases,
                                boolean repeatOffender,
                                String flagSeverity) {
        this.studentProfile = studentProfile;
        this.totalCases = totalCases;
        this.repeatOffender = repeatOffender;
        this.flagSeverity = flagSeverity;
    }

    // -------------------------
    // Getters & Setters
    // -------------------------

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

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public boolean isRepeatOffender() {
        return repeatOffender;
    }

    public void setRepeatOffender(boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }

    public String getFlagSeverity() {
        return flagSeverity;
    }

    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }
}
