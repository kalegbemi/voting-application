package com.ingryd_capstone_project.votingapplication.dto;

import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.model.Voter;
import lombok.Builder;

@Builder
public record VoteRequest(
        Voter voterId, Candidate candidateId, Election electionId
){}
