package com.ingryd_capstone_project.votingapplication.controller;

import com.ingryd_capstone_project.votingapplication.model.AuthenticationRequest;
import com.ingryd_capstone_project.votingapplication.model.AuthenticationResponse;
import com.ingryd_capstone_project.votingapplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @PreAuthorize("hasRole('ADMIN')")
    public AuthenticationResponse adminLogin(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        return adminService.adminLogin((authenticationRequest));
    }
}
