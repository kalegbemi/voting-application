package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.enums.Role;
import com.ingryd_capstone_project.votingapplication.model.Voter;
import com.ingryd_capstone_project.votingapplication.repository.VoterRepository;
import com.ingryd_capstone_project.votingapplication.request.VoterUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@AllArgsConstructor
@Service
public class VoterService {

    private final VoterRepository voterRepository;
    private final EmailService emailService;

    @CacheEvict(value = "allVoter", allEntries = true)
    public Voter saveVoter(UserRegisterationRequest request) {
        Voter voter = new Voter();
        voter.setFirstName(request.getFirstName());
        voter.setLastName(request.getLastName());
        voter.setUsername(request.getUsername());
        voter.setPassword(request.getPassword());
        voter.setEmail(request.getEmail());
        voter.setRegistered(request.getRegistered());
        voter.setRole(Role.VOTER);
        voterRepository.save(voter);
        String name = voter.getFirstName() + " " + voter.getLastName();
        emailService.sendVoterMessage(voter.getEmail(),name, voter.getRole().name());
        emailService.sendMessage(voter.getEmail(),name, voter.getRole().name());
        return voter;
    }


    public Map<String, Boolean> saveAllUsers(List<Voter> users){
        Map<String, Boolean> response = new HashMap<>();
        for(Voter user : users){
            response.put(user.getFullName()+"Voter added successfully", true);
        }
        return response;
    }
   
    @Cacheable(value = "allvoters")
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }
    @Cacheable(value = "single voter", key = "id")
    public Optional<Voter> getVoterById(long voterId) {

        return voterRepository.findById(voterId);
    }
    @CacheEvict(value = "single voter", allEntries = true)
    public void deleteVoter(long voterId) {
        voterRepository.deleteById(voterId);
    }
    public boolean authenticateVoter(String username, String password) {
        Voter voter = voterRepository.findByUsername(username);
        return voter != null && voter.getPassword().equals(password);
    }
    @CacheEvict(value = "single voter", allEntries = true)
    public String updateVoter(long id, VoterUpdateRequest updateRequest) {
        Optional<Voter> optionalVoter = voterRepository.findById(id);

        if (optionalVoter.isPresent()) {
            Voter toUpdate = optionalVoter.get();

            toUpdate.setUsername(updateRequest.getUsername());
            toUpdate.setPassword(updateRequest.getPassword());
            toUpdate.setFirstName(updateRequest.getFirstName());
            toUpdate.setEmail(updateRequest.getEmail());
            toUpdate.setLastName(updateRequest.getLastName());

            voterRepository.save(toUpdate);

            return "User successfully updated";
        } else {

            return "User not found with ID: " + id;
        }
    }
}
