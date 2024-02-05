package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import com.ingryd_capstone_project.votingapplication.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@AllArgsConstructor
@Service
public class CandidateService {

   private final CandidateRepository candidateRepository;

   public long getid() {
      return candidateRepository.getId();
   }
   @CacheEvict(value = "allCandidate", allEntries = true)
   public Candidate saveCandidate(Candidate candidate) {
      System.out.println(getid());
      System.out.println(getid() + 1);
      candidate.setId(getid() + 1);
      return candidateRepository.save(candidate);
   }

   public Map<String, Boolean> saveAllUsers(List<Candidate> users){
      Map<String, Boolean> response = new HashMap<>();
      for(Candidate user : users){
         response.put(user.getPosition()+" Candidate added successfully", true);
      }
      return response;
   }
   public List<Candidate> getAllCandidates() {
      return candidateRepository.findAll();
   }

   public Candidate getCandidateById(long id) {
      return candidateRepository.findById(id).orElse(null);
   }



}
