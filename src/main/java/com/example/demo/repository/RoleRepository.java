package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

// public interface RoleRepository extends JpaRepository<Role, Long> {
// }
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}

