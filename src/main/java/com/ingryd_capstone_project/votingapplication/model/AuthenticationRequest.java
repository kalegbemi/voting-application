package com.ingryd_capstone_project.votingapplication.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
