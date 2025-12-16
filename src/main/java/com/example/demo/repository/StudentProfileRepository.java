package com.example.Academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Academy.entity.StudentProfile;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile,Long> {

    
}
