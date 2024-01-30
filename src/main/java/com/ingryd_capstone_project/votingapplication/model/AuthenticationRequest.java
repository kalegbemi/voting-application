package com.ingryd_capstone_project.votingapplication.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationRequest {
    String username;
    String password;
}
