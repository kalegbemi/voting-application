package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findCandidateById (long id);
    Candidate findCandidateByFirstName(String firstName);
    Candidate findCandidateByLastName(String lastName);
}
