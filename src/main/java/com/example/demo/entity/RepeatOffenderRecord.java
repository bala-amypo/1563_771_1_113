// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDate;

// @Entity
// @Table(name = "repeat_offender_records")
// public class RepeatOffenderRecord {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private StudentProfile studentProfile;

//     private Integer totalCases;
//     private LocalDate firstIncidentDate;
//     private String flagSeverity;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public StudentProfile getStudentProfile() { return studentProfile; }
//     public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
//     public Integer getTotalCases() { return totalCases; }
//     public void setTotalCases(Integer totalCases) { this.totalCases = totalCases; }
//     public LocalDate getFirstIncidentDate() { return firstIncidentDate; }
//     public void setFirstIncidentDate(LocalDate firstIncidentDate) { this.firstIncidentDate = firstIncidentDate; }
//     public String getFlagSeverity() { return flagSeverity; }
//     public void setFlagSeverity(String flagSeverity) { this.flagSeverity = flagSeverity; }
// }



package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    // 🔹 Used by calculator & tests
    private Integer totalCases;

    private Integer offenseCount;

    private String flagSeverity;

    private Boolean active = true;

    // ✅ No-args constructor (required by JPA)
    public RepeatOffenderRecord() {
    }

    // ✅ Parameterized constructor (required by tests)
    public RepeatOffenderRecord(StudentProfile studentProfile,
                                Integer offenseCount,
                                Boolean active) {
        this.studentProfile = studentProfile;
        this.offenseCount = offenseCount;
        this.active = active;
    }

    // ===== GETTERS & SETTERS =====

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

    public Integer getOffenseCount() {
        return offenseCount;
    }

    public void setOffenseCount(Integer offenseCount) {
        this.offenseCount = offenseCount;
    }

    public String getFlagSeverity() {
        return flagSeverity;
    }

    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
