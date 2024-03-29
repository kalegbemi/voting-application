package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.enums.Role;
import com.ingryd_capstone_project.votingapplication.exception.AdminNotFoundException;
import com.ingryd_capstone_project.votingapplication.model.Admin;
import com.ingryd_capstone_project.votingapplication.model.AuthenticationRequest;
import com.ingryd_capstone_project.votingapplication.model.AuthenticationResponse;
import com.ingryd_capstone_project.votingapplication.repository.AdminRepository;
import com.ingryd_capstone_project.votingapplication.request.AdminRegistrationRequest;
import com.ingryd_capstone_project.votingapplication.request.AdminUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AdminService {
    @Autowired
    private final AdminRepository adminRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @CacheEvict(value = "allAdmins", allEntries = true)
    public Admin saveAdmin(AdminRegistrationRequest adminRegistrationRequest) {
       try{
           Admin admin = new Admin();
           admin.setUsername(adminRegistrationRequest.getUsername());
           admin.setEmail(adminRegistrationRequest.getEmail());
           admin.setFullName(adminRegistrationRequest.getFullName());
           admin.setPassword(passwordEncoder.encode(adminRegistrationRequest.getPassword()));
           admin.setRole(Role.ADMIN);
           return adminRepository.save(admin);
       }catch (Exception e){
           System.out.println("Something went wrong" + e.getMessage());
           return null;
       }
    }
public AuthenticationResponse adminLogin(AuthenticationRequest authenticationRequest) {
     try {
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                 authenticationRequest.getPassword()));
         Admin admin = adminRepository.findByUsername(authenticationRequest.getUsername());
         String token = jwtService.generateToken(admin);
         System.out.println("Login Successful");
         System.out.println(token);
         return AuthenticationResponse.builder().token(token).build();

     } catch (Exception e) {
         System.out.println("Something went wrong" + e.getMessage());
         return null;
           }
     }
     @Cacheable("allAdmins")
     public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
}
@Cacheable(value = "singleAdmins", key = "#id")
public Admin getAdminById(int id) {
        return adminRepository.findById(id).orElseThrow(()->new AdminNotFoundException("Admin with id: " + id + "can not be found"));
}
public Admin updateAdmin(int id, AdminUpdateRequest updateRequest) {

    Admin toUpdate = getAdminById(id);
    toUpdate.setUsername(updateRequest.getUsername());
    toUpdate.setPassword(updateRequest.getPassword());
    toUpdate.setRole(updateRequest.getRole());
    toUpdate.setFullName(updateRequest.getFullName());
    toUpdate.setEmail(updateRequest.getEmail());
    return adminRepository.save(toUpdate);
}
public Admin updatePassword(int id, String newPassword) {
    if (newPassword != null && !newPassword.isEmpty()) {
        String hashedPassword = passwordEncoder.encode(newPassword);
        Admin admin = getAdminById(id);
        admin.setPassword(hashedPassword);
        return adminRepository.save(admin);
    } else {
        throw new IllegalArgumentException("New password cannot be null or empty.");
    }
}

@CacheEvict(value = {"allAdmins"})
public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
      }
}

