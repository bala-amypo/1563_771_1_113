package com.example.Academy.entity;

import java.time.LocalDateTime;

public class EvidenceRecord {
    private Long id;
    private IntegrityCase integrityCase;
    private String evidenceType;
    private  String content;
    private String submittedBy;
    private LocalDateTime submittedAt;
     public EvidenceRecord(){

    }
    public EvidenceRecord(IntegrityCase integrityCase, String evidenceType, String content, String submittedBy,
            LocalDateTime submittedAt) {
        this.integrityCase = integrityCase;
        this.evidenceType = evidenceType;
        this.content = content;
        this.submittedBy = submittedBy;
        this.submittedAt = submittedAt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public IntegrityCase getIntegrityCase() {
        return integrityCase;
    }
    public void setIntegrityCase(IntegrityCase integrityCase) {
        this.integrityCase = integrityCase;
    }
    public String getEvidenceType() {
        return evidenceType;
    }
    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSubmittedBy() {
        return submittedBy;
    }
    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
   
    
}
