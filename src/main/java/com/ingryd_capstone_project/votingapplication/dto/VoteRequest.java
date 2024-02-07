
package com.ingryd_capstone_project.votingapplication.dto;

import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.model.Voter;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class VoteRequest {
    private Long voterId;
    private Long candidateId;
    private Long electionId;
}
