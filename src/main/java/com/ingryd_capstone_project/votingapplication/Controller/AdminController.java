package com.ingryd_capstone_project.votingapplication.Controller;

import com.ingryd_capstone_project.votingapplication.Model.Admin;
import com.ingryd_capstone_project.votingapplication.Model.AuthenticationRequest;
import com.ingryd_capstone_project.votingapplication.Model.AuthenticationResponse;
import com.ingryd_capstone_project.votingapplication.Request.AdminRegistrationRequest;
import com.ingryd_capstone_project.votingapplication.Request.AdminUpdateRequest;
import com.ingryd_capstone_project.votingapplication.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admins")
    @PreAuthorize("/Admin")
    public Admin saveAdmin(@RequestBody AdminRegistrationRequest adminRegistrationRequest) {
        return adminService.saveAdmin(adminRegistrationRequest);
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
}

    @PostMapping("/login")
    public AuthenticationResponse adminLogin(@RequestBody AuthenticationRequest authenticationRequest) {
        return adminService.adminLogin((authenticationRequest));
    }

    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody AdminUpdateRequest adminUpdateRequest) {
        return adminService.updateAdmin(id, adminUpdateRequest);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }


}
