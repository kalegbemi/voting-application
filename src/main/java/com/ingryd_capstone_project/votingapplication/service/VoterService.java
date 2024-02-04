
package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Voter;
import com.ingryd_capstone_project.votingapplication.repository.VoterRepository;
import com.ingryd_capstone_project.votingapplication.request.UserRegisterationRequest;
import com.ingryd_capstone_project.votingapplication.request.VoterUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class VoterService {

    private final VoterRepository voterRepository;
    @Cacheable
    public List<Voter> getAllVoters() {

        return voterRepository.findAll();
    }
    @Cacheable
    public Optional<Voter> getVoterById(long voterId) {

        return voterRepository.findById(voterId);
    }

    @CacheEvict
    public Voter createVoter(UserRegisterationRequest voter) {

        return voterRepository.createVoter(voter);
    }
    @CacheEvict
    public void deleteVoter(long voterId) {

        voterRepository.deleteById(voterId);
    }
    public boolean authenticateVoter(String username, String password) {
        Voter voter = voterRepository.findByUsername(username);
        return voter != null && voter.getPassword().equals(password);
    }
    @CacheEvict
    public Voter updateVoter(long id, VoterUpdateRequest updateRequest) {

        return voterRepository.updateVoter();
    }
}