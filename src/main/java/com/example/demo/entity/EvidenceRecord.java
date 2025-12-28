// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "evidence_records")
// public class EvidenceRecord {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "integrity_case_id", nullable = false)
//     private IntegrityCase integrityCase;
    
//     @Column(nullable = false)
//     private String evidenceType;
    
//     @Column(nullable = false, columnDefinition = "TEXT")
//     private String content;
    
//     @Column(nullable = false)
//     private String submittedBy;
    
//     @Column(nullable = false)
//     private LocalDateTime submittedAt = LocalDateTime.now();

//     // Constructors, Getters, Setters
//     public EvidenceRecord() {}
    
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public IntegrityCase getIntegrityCase() { return integrityCase; }
//     public void setIntegrityCase(IntegrityCase integrityCase) { this.integrityCase = integrityCase; }
//     public String getEvidenceType() { return evidenceType; }
//     public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }
//     public String getContent() { return content; }
//     public void setContent(String content) { this.content = content; }
//     public String getSubmittedBy() { return submittedBy; }
//     public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }
//     public LocalDateTime getSubmittedAt() { return submittedAt; }
//     public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
// }




package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evidence_records")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "integrity_case_id", nullable = false)
    private IntegrityCase integrityCase;

    @Column(nullable = false)
    private String evidenceType;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String submittedBy;

    @Column(nullable = false)
    private LocalDateTime submittedAt = LocalDateTime.now();

    // ✅ Required by JPA
    public EvidenceRecord() {}

    /**
     * 🔥 CRITICAL FIX
     * Allows JSON like:
     * "evidenceRecords": ["string"]
     * or
     * "integrityCase": "string"
     */
    @JsonCreator
    public EvidenceRecord(String value) {
        // no-op
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public IntegrityCase getIntegrityCase() { return integrityCase; }
    public void setIntegrityCase(IntegrityCase integrityCase) {
        this.integrityCase = integrityCase;
    }

    public String getEvidenceType() { return evidenceType; }
    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }

    public String getContent() { return content; }
    public void setContent(String content) {
        this.content = content;
    }

    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}

