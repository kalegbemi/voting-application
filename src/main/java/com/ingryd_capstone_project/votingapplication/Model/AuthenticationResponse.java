package com.ingryd_capstone_project.votingapplication.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;

}
