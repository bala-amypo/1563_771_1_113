package com.example.Academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Academy.entity.EvidenceRecord;
@Repository
public interface EvidenceRecordRepository extends JpaRepository<EvidenceRecord,Long> {

    
}