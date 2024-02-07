package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.model.ElectionResult;
import com.ingryd_capstone_project.votingapplication.model.Vote;
import com.ingryd_capstone_project.votingapplication.repository.CandidateRepository;
import com.ingryd_capstone_project.votingapplication.repository.ElectionRepository;
import com.ingryd_capstone_project.votingapplication.repository.ElectionResultRepository;
import com.ingryd_capstone_project.votingapplication.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElectionResultService {

    private final ElectionResultRepository electionResultRepository;
    private final VoteRepository voteRepository;
    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;



//    public Map<String,Integer> getTotalResult(long candidateId, long electionId) {
//        Integer electionResult = electionResultRepository.findByElectionId(electionId).size();
//        Integer candidateResult = electionResultRepository.findByCandidateId(candidateId).size();
//        Election election = electionRepository.findById(electionId).orElseThrow();
//        Candidate candidate = candidateRepository.findCandidateById(candidateId);
//        String name = candidate.getFirstName() + " " + candidate.getLastName();
//        return Map.of(name, candidateResult, election.getTitle(), electionResult);
//    }

//    public ElectionResult getResultByCandidates(long electionId) {
//
//        List<ElectionResult> totalResultByElectionId = electionResultRepository.findByElectionId(electionId);
//        List<Vote> total = voteRepository.
//
//        Map<String, Integer> candidateResult = new HashMap<>();
//        for (ElectionResult x: totalResultByElectionId) {
//
//            String name = x.getCandidate().getFirstName() + " " + x.getCandidate().getLastName();
//            int result = x.getCandidate()
//        }
//    }


//    public int getAllElection (long electionId) {
//        List<Vote> vote = voteRepository.findAllByElectionId(electionId);
//        return vote.size();
//    }


   }



