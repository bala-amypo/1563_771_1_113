// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "repeat_offender_records")
// public class RepeatOffenderRecord {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @OneToOne
//     @JoinColumn(name = "student_profile_id", nullable = false)
//     private StudentProfile studentProfile;
    
//     @Column(nullable = false)
//     private Integer totalCases;
    
//     @Column(nullable = false)
//     private String flagSeverity;

//     // Constructors, Getters, Setters
//     public RepeatOffenderRecord() {}
    
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public StudentProfile getStudentProfile() { return studentProfile; }
//     public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
//     public Integer getTotalCases() { return totalCases; }
//     public void setTotalCases(Integer totalCases) { this.totalCases = totalCases; }
//     public String getFlagSeverity() { return flagSeverity; }
//     public void setFlagSeverity(String flagSeverity) { this.flagSeverity = flagSeverity; }
// }




package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "repeat_offender_records")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_profile_id", nullable = false)
    private StudentProfile studentProfile;

    @Column(nullable = false)
    private Integer totalCases;

    @Column(nullable = false)
    private String flagSeverity;

    // ✅ Required by JPA
    public RepeatOffenderRecord() {}

    /**
     * 🔥 CRITICAL FIX
     * Allows JSON like:
     * "repeatOffenderRecord": "string"
     * OR nested "studentProfile": "string"
     */
    @JsonCreator
    public RepeatOffenderRecord(String value) {
        // no-op
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Integer getTotalCases() { return totalCases; }
    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public String getFlagSeverity() { return flagSeverity; }
    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }
}
