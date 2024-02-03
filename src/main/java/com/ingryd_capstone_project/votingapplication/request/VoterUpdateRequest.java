package com.ingryd_capstone_project.votingapplication.request;

import lombok.Data;

@Data
public class VoterUpdateRequest {
    private String username;
    private String password;
    private String role;
}
