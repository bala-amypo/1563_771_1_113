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
    private String status;   // ✅ THIS WAS MISSING

    // ===== getters & setters =====

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {   // ✅ REQUIRED
        this.status = status;
    }
}
