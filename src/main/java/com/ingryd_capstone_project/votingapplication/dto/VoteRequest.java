package com.ingryd_capstone_project.votingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteRequest {

    private Voter voterId;
    private Candidate candidateId;
    private Long electionId;

}
