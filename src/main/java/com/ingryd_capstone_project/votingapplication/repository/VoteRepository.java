package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.Vote;
import com.ingryd_capstone_project.votingapplication.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Vote findByVoterId(long id);
    List<Vote> findByVoter(Voter voter);

    //List<Vote> findByElectionIdAndCandidate(Long electionId, Long candidateId);
    List<Vote> findAllByElectionId(long electionId);


    //Vote findByVoterId(long voteId);

    //Vote findByVoterId(long id);

}

