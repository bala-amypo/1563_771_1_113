package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(unique = true, nullable = false)
    private String studentId; 

    private String name; 

    @Column(unique = true, nullable = false)
    private String email;

    private String program; 
    
    private Integer yearLevel; 

    private Boolean isRepeatOffender = false; 

    private LocalDateTime createdAt; 

   
@OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL)
private List<IntegrityCase> integrityCases = new ArrayList<>();
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(); //
    }

    public StudentProfile() {} //

    public StudentProfile(String studentId, String name, String email, String program, Integer yearLevel) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Integer getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(Integer yearLevel) {
        this.yearLevel = yearLevel;
    }

    public Boolean getIsRepeatOffender() {
        return isRepeatOffender;
    }

    public void setIsRepeatOffender(Boolean isRepeatOffender) {
        this.isRepeatOffender = isRepeatOffender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}