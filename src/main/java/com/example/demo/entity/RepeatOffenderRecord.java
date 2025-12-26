package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile studentProfile;

    private Boolean repeatOffender;

    private Integer totalCases;

    // ✅ REQUIRED: Default constructor
    public RepeatOffenderRecord() {
    }

    // ✅ Getter & Setter (IMPORTANT)
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

    // 🔥 THIS FIXES YOUR ERROR
    public Boolean getRepeatOffender() {
        return repeatOffender;
    }

    public void setRepeatOffender(Boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }

    public Integer getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }
}
