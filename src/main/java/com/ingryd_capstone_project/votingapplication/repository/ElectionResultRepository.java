package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import com.ingryd_capstone_project.votingapplication.model.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionResultRepository extends JpaRepository<ElectionResult,Long> {
    List<ElectionResult> findByCandidateId(Long candidateId);
    List<ElectionResult> findByElectionId(Long electionId);

    // List<ElectionResult> findElectionResultsByCandidateAndVote(Long candidateId, Long voteId);
}
