package com.example.Academy.entity;

import java.time.LocalDate;

public class RepeatOffenderRecord {
    private Long id;
    private StudentProfile studentProfile;
    private Integer totalCases;
    private LocalDate lastincidentDate;
    private String flagSeverity;
    public RepeatOffenderRecord(){

    }
    public RepeatOffenderRecord(StudentProfile studentProfile, Integer totalCases, LocalDate lastincidentDate,
            String flagSeverity) {
        this.studentProfile = studentProfile;
        this.totalCases = totalCases;
        this.lastincidentDate = lastincidentDate;
        this.flagSeverity = flagSeverity;
    }
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
    public Integer getTotalCases() {
        return totalCases;
    }
    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }
    public LocalDate getLastincidentDate() {
        return lastincidentDate;
    }
    public void setLastincidentDate(LocalDate lastincidentDate) {
        this.lastincidentDate = lastincidentDate;
    }
    public String getFlagSeverity() {
        return flagSeverity;
    }
    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }
   
}
