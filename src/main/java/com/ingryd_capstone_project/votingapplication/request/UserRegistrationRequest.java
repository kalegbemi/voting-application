package com.ingryd_capstone_project.votingapplication.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRegistrationRequest {

    private String firstName;

    private String lastName;

    private String username;

    private String password;
}
