package com.ingryd_capstone_project.votingapplication.controller;

import com.ingryd_capstone_project.votingapplication.service.ElectionResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/electionResult")
public class ElectionResultController {

    private ElectionResultService electionResultService;
//    private CandidateRepository candidateRepository;

//    @GetMapping("/total/{candidateId}")
//    public ResponseEntity<Integer> getTotalVotesForCandidate(@PathVariable long candidateId) {
//        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
//
//        if (candidate.isPresent()) {
//            Candidate candidate1 = candidate.get();
//            int totalVotes = electionResultService.getTotalVotesForCandidate(candidate1);
//            return ResponseEntity.ok(totalVotes);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}


