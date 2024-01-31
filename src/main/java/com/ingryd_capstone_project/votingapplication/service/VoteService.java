package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.model.Vote;
import com.ingryd_capstone_project.votingapplication.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {

    private VoteRepository voteRepository;
    public ResponseEntity<Vote> getElectionById(Long electionId) {
       return new ResponseEntity<>(voteRepository.findById(electionId).get(), HttpStatus.OK);
    }

    public ResponseEntity<Vote> getVoteByVoterId(long voterId) {
        return new ResponseEntity<>(voteRepository.findByVoterId(voterId), HttpStatus.OK);
    }


    public ResponseEntity<List<Vote>> findAllVote() {

        return new ResponseEntity<>(voteRepository.findAll(),HttpStatus.OK);
    }
}
