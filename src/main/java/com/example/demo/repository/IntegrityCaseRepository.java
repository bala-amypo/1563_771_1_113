package com.example.Academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Academy.entity.IntegrityCase;


@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {
}

   
