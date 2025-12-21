package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    private Integer totalCases;
    private LocalDate lastIncidentDate;
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
