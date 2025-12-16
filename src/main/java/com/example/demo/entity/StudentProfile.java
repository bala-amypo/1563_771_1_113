package com.example.Academy.entity;

import java.time.LocalDateTime;

public class StudentProfile {
    public StudentProfile(String studentid, String name, String email, String program, Integer yearLevel,
            Boolean isRepeatOffender, LocalDateTime createAt) {
        this.studentid = studentid;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
        this.isRepeatOffender = isRepeatOffender;
        this.createAt = createAt;
    }
    private Long id;
    private String studentid;
    private String name;
    private String email;
    private String program;
    private Integer yearLevel;
    private Boolean isRepeatOffender;
    private LocalDateTime createAt;
    public StudentProfile(){

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentid() {
        return studentid;
    }
    public void setStudentid(String studentid) {
        this.studentid = studentid;
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
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    
}
