package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionResultRepository extends JpaRepository<ElectionResult, Long> {



}
