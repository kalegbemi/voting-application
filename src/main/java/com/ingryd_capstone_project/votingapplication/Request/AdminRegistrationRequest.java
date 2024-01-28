package com.ingryd_capstone_project.votingapplication.Request;

import com.ingryd_capstone_project.votingapplication.Model.Role;
import lombok.Data;

@Data
public class AdminRegistrationRequest {
    private String username;
    private String password;
    public Role role;
}
