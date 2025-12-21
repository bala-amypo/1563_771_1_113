package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "integrity_case")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentIdentifier;

    @Column(nullable = false)
    private String status;   
    private String courseCode;
    private String instructorName;
    private String description;
    private LocalDate ins

   public IntegrityCase() {}

    public IntegrityCase(StudentProfile studentProfile, String courseCode,
                         String instructorName, String description,
                         LocalDate incidentDate) {
        this.studentProfile = studentProfile;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
        this.description = description;
        this.incidentDate = incidentDate;
    }

    // Getters and Setters
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
