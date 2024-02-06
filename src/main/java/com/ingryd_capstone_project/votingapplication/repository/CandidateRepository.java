package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findCandidateById (long id);
    Candidate findCandidateByFirstName(String firstName);
    Candidate findCandidateByLastName(String lastName);
    Candidate findCandidateByPosition(String position);
    Candidate findCandidateByPartyAffiliation(String partyAffiliation);

    long getId();
}
