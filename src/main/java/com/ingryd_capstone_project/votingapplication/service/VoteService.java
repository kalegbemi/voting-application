package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Vote;
import com.ingryd_capstone_project.votingapplication.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private VoteRepository voteRepository;
    public ResponseEntity<Vote> getElectionById(Long electionId) {
       return new ResponseEntity<>(voteRepository.findById(electionId).get(), HttpStatus.OK);
    }

    public ResponseEntity<Voter> getVoteByVoterId(long voterId) {
        return new ResponseEntity<>(voteRepository.findByVoterId(voterId), HttpStatus.OK);
    }
}
