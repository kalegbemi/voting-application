package com.ingryd_capstone_project.votingapplication.request;

import lombok.Data;

@Data
public class UserRegisterationRequest {

    private String firstName;

    private String lastName;
    private String username;
    private String password;

}
