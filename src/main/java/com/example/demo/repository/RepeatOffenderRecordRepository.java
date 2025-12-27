// package com.example.demo.repository;
// import com.example.demo.entity.RepeatOffenderRecord;
// import com.example.demo.entity.StudentProfile;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface RepeatOffenderRecordRepository extends JpaRepository<RepeatOffenderRecord, Long> {
//     Optional<RepeatOffenderRecord> findByStudentProfile(StudentProfile studentProfile);
// }



package com.example.demo.repository;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepeatOffenderRecordRepository
        extends JpaRepository<RepeatOffenderRecord, Long> {

    // ✅ MUST return List (tests expect this)
    List<RepeatOffenderRecord> findByStudentProfile(StudentProfile studentProfile);
}
