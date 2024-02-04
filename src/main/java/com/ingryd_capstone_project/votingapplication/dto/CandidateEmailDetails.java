package com.ingryd_capstone_project.votingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CandidateEmailDetails {
    private String to;
    private String name;
    private String role;
    private String party;
    private String position;
}
