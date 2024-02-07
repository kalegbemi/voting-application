package com.ingryd_capstone_project.votingapplication.request;

import lombok.Data;

@Data
public class CandidateUpdateRequest {
    private String firstName;
    private String lastName;
    private String position;
    private String partyAffiliation;
}
