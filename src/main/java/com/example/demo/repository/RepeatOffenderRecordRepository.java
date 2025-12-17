package com.example.Academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Academy.entity.RepeatOffenderRecord;
@Repository
public interface RepeatOffenderRecordRepository extends JpaRepository<RepeatOffenderRecord,Long> {
    
}
