
//package com.ingryd_capstone_project.votingapplication.service;
//
//import com.ingryd_capstone_project.votingapplication.model.Election;
//import com.ingryd_capstone_project.votingapplication.model.Vote;
//import com.ingryd_capstone_project.votingapplication.repository.VoteRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class VoteService {
//
//    private VoteRepository voteRepository;
//    public ResponseEntity<Vote> getElectionById(Long electionId) {
//       return new ResponseEntity<>(voteRepository.findById(electionId).get(), HttpStatus.OK);
//    }
//
//    public ResponseEntity<Vote> getVoteByVoterId(long voterId) {
//        return new ResponseEntity<>(voteRepository.findByVoterId(voterId), HttpStatus.OK);
//    }
//
//
//    public ResponseEntity<List<Vote>> findAllVote() {
//
//        return new ResponseEntity<>(voteRepository.findAll(),HttpStatus.OK);
//    }
//}

package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.dto.VoteRequest;
import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.model.Vote;
import com.ingryd_capstone_project.votingapplication.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {

    private VoteRepository voteRepository;

    @Cacheable("getVoteByElectionId")
    public ResponseEntity<Vote> getElectionById(long id) {
       return new ResponseEntity<>(voteRepository.findById(id).get(), HttpStatus.OK);
    }
    @Cacheable("getVoteByVoterId")
    public ResponseEntity<Vote> getVoteByVoterId(long Id) {
        return new ResponseEntity<>(voteRepository.findByVoterId(Id), HttpStatus.OK);
    }

    @Cacheable("allVote")
    public ResponseEntity<List<Vote>> findAllVote() {

        return new ResponseEntity<>(voteRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Vote> castVote(VoteRequest voteRequest) {
        Vote vote1 = Vote.builder()
                .voter(voteRequest.voterId())
                .candidate(voteRequest.candidateId())
                .election(voteRequest.electionId())
                .build();
        return new ResponseEntity<>(voteRepository.save(vote1),HttpStatus.OK);
    }
}
