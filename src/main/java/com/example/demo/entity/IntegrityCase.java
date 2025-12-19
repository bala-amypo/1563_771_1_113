package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.example.demo.entity.StudentProfile;

import jakarta.persistence.*;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(name="Student_profile")
    @JoinColumn
    private StudentProfile studentProfile;

    @Column(nullable = false)
    private String courseCode;

    @Column(nullable = false)
    private String instructorName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String status; 

    @Column(nullable = false)
    private LocalDate incidentDate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "OPEN";
        }
    }

   

    public IntegrityCase(StudentProfile studentProfile, String courseCode,
                         String instructorName, String description,
                         LocalDate incidentDate) {
        this.studentProfile = studentProfile;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
        this.description = description;
        this.incidentDate = incidentDate;
    }

    public Long getId() {
        return id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}