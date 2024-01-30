package com.ingryd_capstone_project.votingapplication.request;

import com.ingryd_capstone_project.votingapplication.model.Role;
import lombok.Data;

@Data
public class AdminUpdateRequest {

    public String username;
    public String password;
    public Role role;
}
