package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long, PK

    @Column(unique = true, nullable = false)
    private String studentId; // studentId must be unique

    private String name; // name (String)

    @Column(unique = true, nullable = false)
    private String email; // email must be unique

    private String program; // program (String)
    
    private Integer yearLevel; // yearLevel (Integer)

    private Boolean isRepeatOffender = false; // auto-updated when multiple cases exist

    private LocalDateTime createdAt; // createdAt (LocalDateTime)

    // RELATIONSHIPS
    
    @OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL)
    private List<IntegrityCase> integrityCases = new ArrayList<>();

    @OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL)
    private List<RepeatOffenderRecord> repeatOffenderRecords = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(); 
    }

    
    public StudentProfile() {}

    public StudentProfile(String studentId, String name, String email, String program, Integer yearLevel) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getIsRepeatOffender() { return isRepeatOffender; }
    public void setIsRepeatOffender(Boolean isRepeatOffender) { this.isRepeatOffender = isRepeatOffender; }

    public List<IntegrityCase> getIntegrityCases() { return integrityCases; }
    public void setIntegrityCases(List<IntegrityCase> integrityCases) { this.integrityCases = integrityCases; }
}