package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profile",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "student_identifier"),
           @UniqueConstraint(columnNames = "email")
       })
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_identifier", nullable = false, unique = true, length = 50)
    private String studentIdentifier;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String department;

    /* ===== Constructors ===== */

    public StudentProfile() {
    }

    public StudentProfile(String studentIdentifier, String name, String email, String department) {
        this.studentIdentifier = studentIdentifier;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    /* ===== Getters & Setters ===== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public void setStudentIdentifier(String studentIdentifier) {
        this.studentIdentifier = studentIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}
