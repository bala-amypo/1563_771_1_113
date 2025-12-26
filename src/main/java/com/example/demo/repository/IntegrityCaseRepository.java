package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StudentProfile;
import java.util.List;

// public interface IntegrityCaseRepository
//         extends JpaRepository<IntegrityCase, Long> {

//     List<IntegrityCase> findByStudentProfile_Id(Long studentId);

//     List<IntegrityCase> findByStatus(String status);
//     List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentIdentifier(String studentIdentifier);

    List<IntegrityCase> findRecentCasesByStatus(String status, LocalDate date);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);
}

}
