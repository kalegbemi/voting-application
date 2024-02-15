package com.ingryd_capstone_project.votingapplication.controller;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import com.ingryd_capstone_project.votingapplication.request.CandidateRegisterationRequest;
import com.ingryd_capstone_project.votingapplication.request.CandidateUpdateRequest;
import com.ingryd_capstone_project.votingapplication.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/save")
    public Candidate saveCandidate (@RequestBody CandidateRegisterationRequest candidateRegisterationRequest){
       return candidateService.saveCandidate(candidateRegisterationRequest);
    }

    @PostMapping("/authenticate")
    public boolean authenticateCandidate(@RequestParam String username, @RequestParam String password) {
        return candidateService.authenticateCandidate(username, password);
    }

    @GetMapping("/allcandidates")
    public List <Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/candidates/{id}")
    public Candidate getCandidateById (@PathVariable long id) {
        return candidateService.getCandidateById(id).orElse(null);
    }

    @PutMapping("/candidates/{id}")
    public String updateCandidate (@PathVariable long id, @RequestBody CandidateUpdateRequest updateRequest){
        return candidateService.updateCandidate(id, updateRequest);
    }

    @DeleteMapping("/candidates/{id}")
    public void deleteCandidate (@PathVariable long id){
        candidateService.deleteById(id);
    }

}
