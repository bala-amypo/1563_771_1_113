package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IntegrityCase;


@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {
}

   
