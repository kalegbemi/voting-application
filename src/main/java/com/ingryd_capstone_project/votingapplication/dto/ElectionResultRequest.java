package com.ingryd_capstone_project.votingapplication.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ElectionResultRequest {

    public Long electionId;
    public Long voteId;


}
