package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.ElectionResult;
import com.ingryd_capstone_project.votingapplication.repository.ElectionResultRepository;
import com.ingryd_capstone_project.votingapplication.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionResultService {

    private final ElectionResultRepository resultRepository;
    private final VoteRepository voteRepository;

    public int getTotalVotesForCandidate(Candidate candidate) {
        List<ElectionResult> results = voteRepository.findByCandidate(candidate);
       return results.size();
    }



}
