package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentId;

    private String name;
    private String email;
    private String program;
    private Integer yearLevel;

    @Column(nullable = false)
    private Boolean repeatOffender = false;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public StudentProfile() {}

    public StudentProfile(String studentId, String name, String email,
                          String program, Integer yearLevel) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (repeatOffender == null) {
            repeatOffender = false;
        }
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public Integer getYearLevel() { return yearLevel; }
    public void setYearLevel(Integer yearLevel) { this.yearLevel = yearLevel; }

    public Boolean getRepeatOffender() { return repeatOffender; }
    public void setRepeatOffender(Boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

public void setCreatedAt(LocalDateTime time) {
    this.createdAt = time;
}
}

