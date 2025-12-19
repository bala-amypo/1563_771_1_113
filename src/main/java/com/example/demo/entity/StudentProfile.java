package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class StudentProfile {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column(unique = true)
private String studentid;
private String name;
@Column(unique = true)
private String email;
private String program;
private Integer yearLevel;

private Boolean isRepeatOffender = false;
private LocalDateTime createdAt;
@PrePersist
protected void onCreate() {
this.createdAt = LocalDateTime.now();
}
@OneToMany(mappedby="studentProfile")
public<List> lis
public StudentProfile(String studentid, String name, String email, String program, Integer yearLevel,
Boolean isRepeatOffender, LocalDateTime createdAt) {
this.studentid = studentid;
this.name = name;
this.email = email;
this.program = program;
this.yearLevel = yearLevel;
this.isRepeatOffender = isRepeatOffender;
this.createdAt = createdAt;
}


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
public LocalDateTime getCreatedAt() {
return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
this.createdAt = createdAt;
}


}





