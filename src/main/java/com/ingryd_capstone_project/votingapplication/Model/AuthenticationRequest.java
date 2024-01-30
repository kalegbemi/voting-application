package com.ingryd_capstone_project.votingapplication.Model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationRequest {
    String username;
    String password;
}
