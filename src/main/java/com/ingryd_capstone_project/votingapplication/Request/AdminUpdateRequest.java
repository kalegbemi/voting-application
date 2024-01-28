package com.ingryd_capstone_project.votingapplication.Request;

import com.ingryd_capstone_project.votingapplication.Model.Role;
import lombok.Data;

@Data
public class AdminUpdateRequest {

    public String username;
    public String password;
    public Role role;
}
