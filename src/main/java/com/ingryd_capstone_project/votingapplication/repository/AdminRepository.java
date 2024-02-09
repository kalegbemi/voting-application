package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.Admin;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Admin a SET a.password = :hashedPassword WHERE a.adminId = :adminId")
    Admin updatePassword(String adminId, String hashedPassword);
}
