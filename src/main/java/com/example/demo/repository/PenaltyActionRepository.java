package com.example.Academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Academy.entity.PenaltyAction;
@Repository
public interface PenaltyActionRepository extends JpaRepository<PenaltyAction ,Long> {
    
}
