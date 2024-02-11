package com.ingryd_capstone_project.votingapplication.request;

import com.ingryd_capstone_project.votingapplication.enums.Role;
import lombok.Data;

@Data
public class UserRegisterationRequest {

    private String firstName;

    private String lastName;
    private String username;
    private String password;
    private Boolean registered;
    private Role role;

}
