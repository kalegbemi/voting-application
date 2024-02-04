package com.ingryd_capstone_project.votingapplication.request;

import com.ingryd_capstone_project.votingapplication.enums.Role;
import lombok.Data;

@Data
public class AdminRegistrationRequest {
    private String username;
    private String password;
    public Role role;
}
