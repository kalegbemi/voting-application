package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findCandidateByFirstName(String firstName);
    List<Candidate> findCandidateByLastName(String lastName);
    List<Candidate> findCandidateByPosition(String position);
    List<Candidate> findCandidateByPartyAffiliation(String partyAffiliation);

}
