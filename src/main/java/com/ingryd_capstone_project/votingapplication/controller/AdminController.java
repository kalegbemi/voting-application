package com.ingryd_capstone_project.votingapplication.controller;

import com.ingryd_capstone_project.votingapplication.model.Admin;
import com.ingryd_capstone_project.votingapplication.model.AuthenticationRequest;
import com.ingryd_capstone_project.votingapplication.model.AuthenticationResponse;
import com.ingryd_capstone_project.votingapplication.request.AdminRegistrationRequest;
import com.ingryd_capstone_project.votingapplication.request.AdminUpdateRequest;
import com.ingryd_capstone_project.votingapplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin saveAdmin(@RequestBody AdminRegistrationRequest adminRegistrationRequest) {
        return adminService.saveAdmin(adminRegistrationRequest);
    }

    @GetMapping("/admins")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
}

    @PostMapping("/login")
    @PreAuthorize("hasRole('ADMIN')")
    public AuthenticationResponse adminLogin(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        return adminService.adminLogin((authenticationRequest));
    }

    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody AdminUpdateRequest adminUpdateRequest) {
        return adminService.updateAdmin(id, adminUpdateRequest);
    }

    @PutMapping("/admins/{id}/update-password")
    public Admin updatePassword(@PathVariable int id, @RequestParam String newPassword) {
        return adminService.updatePassword(id, newPassword);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable int id) {

        adminService.deleteAdmin(id);
    }
}
