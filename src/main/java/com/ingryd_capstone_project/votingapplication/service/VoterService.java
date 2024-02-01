
package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Voter;
import com.ingryd_capstone_project.votingapplication.repository.VoterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class VoterService {

    private final VoterRepository voterRepository;

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Optional<Voter> getVoterById(long voterId) {
        return voterRepository.findById(voterId);
    }

    public Voter createVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public void deleteVoter(long voterId) {
        voterRepository.deleteById(voterId);
    }

    // You can add more methods based on your application requirements

    // For example, you might want to authenticate a voter
    public boolean authenticateVoter(String username, String password) {
        Voter voter = voterRepository.findByUsername(username);
        return voter != null && voter.getPassword().equals(password);
    }
}
