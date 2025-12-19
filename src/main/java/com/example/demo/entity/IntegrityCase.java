package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  21.977 s
[INFO] Finished at: 2025-12-19T04:49:29Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.13.0:compile (default-compile) on project demo: Compilation failure
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/IntegrityCaseController.java:[15,31] cannot access com.example.demo.entity.StudentProfile
[ERROR]   bad source file: /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/StudentProfile.java
[ERROR]     file does not contain class com.example.demo.entity.StudentProfile
[ERROR]     Please remove or make sure it appears in the correct subdirectory of the sourcepath.
[ERROR] 
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
coder@3e81dcb330ee:~/Workspace/demo$ 
import jakarta.persistence.*;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "student_profile_id", nullable = false)
    private StudentProfile studentProfile;

    @Column(nullable = false)
    private String courseCode;

    @Column(nullable = false)
    private String instructorName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String status; 

    @Column(nullable = false)
    private LocalDate incidentDate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "OPEN";
        }
    }

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