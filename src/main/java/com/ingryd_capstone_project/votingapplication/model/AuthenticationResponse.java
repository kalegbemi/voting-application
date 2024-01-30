package com.ingryd_capstone_project.votingapplication.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;

}
