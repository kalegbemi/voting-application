package com.ingryd_capstone_project.votingapplication.Repository;

import com.ingryd_capstone_project.votingapplication.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String name);
}
