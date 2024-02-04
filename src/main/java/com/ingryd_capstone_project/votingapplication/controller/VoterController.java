package com.ingryd_capstone_project.votingapplication.controller;

import com.ingryd_capstone_project.votingapplication.model.Voter;
import com.ingryd_capstone_project.votingapplication.request.UserRegisterationRequest;
import com.ingryd_capstone_project.votingapplication.request.VoterUpdateRequest;
import com.ingryd_capstone_project.votingapplication.service.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public Voter createVoter (@RequestBody UserRegisterationRequest userRegisterationRequest) {
        return voterService.createVoter(userRegisterationRequest);
    }
    @PostMapping("/authenticate")
    public boolean authenticateVoter(@RequestParam String username, @RequestParam String password) {
        return voterService.authenticateVoter(username, password);
    }
    @GetMapping("/allvoters")
    public List <Voter> getAllVoters() {

        return voterService.getAllVoters();
    }

    @GetMapping("/voters/{id}")
    public Voter getVoterById(@PathVariable long id){

        return voterService.getVoterById(id).orElse(null);
    }

    @PutMapping("/voters/{id}")
    public String updateVoter(@PathVariable long id, @RequestBody VoterUpdateRequest updateRequest) {
        return voterService.updateVoter(id, updateRequest);
    }

    @DeleteMapping("/voters/{id}")
    public void deleteVoter (@PathVariable long id) {
        voterService.deleteVoter(id);
    }
}
