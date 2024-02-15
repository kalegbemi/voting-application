package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import com.ingryd_capstone_project.votingapplication.repository.CandidateRepository;
import com.ingryd_capstone_project.votingapplication.request.CandidateRegisterationRequest;
import com.ingryd_capstone_project.votingapplication.request.CandidateUpdateRequest;
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
public class CandidateService {

   private final CandidateRepository candidateRepository;


   @CacheEvict(value = "allCandidate", allEntries = true)
   public Candidate saveCandidate(CandidateRegisterationRequest candidate) {
      candidate.setFirstName(candidate.getFirstName());
      candidate.setLastName(candidate.getLastName());
      candidate.setPosition(candidate.getPosition());
      candidate.setPartyAffiliation(candidate.getPartyAffiliation());
      return candidateRepository.save(candidate);
   }
   public Map<String, Boolean> saveAllUsers(List<Candidate> users){
      Map<String, Boolean> response = new HashMap<>();
      for(Candidate user : users){
         response.put(user.getPosition()+" Candidate added successfully", true);
      }
      return response;
   }
   @Cacheable("all candidates")
   public List<Candidate> getAllCandidates() {
      return candidateRepository.findAll();
   }
   @Cacheable(value = "single candidate", key = "id")
   public Candidate getCandidateById(long id) {
      return candidateRepository.findById(id).orElse(null);
   }
   @CacheEvict(value = "simgle candidate", allEntries = true)
   public String updateCandidate(long id, CandidateUpdateRequest updateRequest) {
      Optional<Candidate> optionalCandidate = candidateRepository.findById(id);

      if (optionalCandidate.isPresent()) {
         Candidate toUpdate = optionalCandidate.get();

         toUpdate.setFirstName(updateRequest.getFirstName());
         toUpdate.setLastName(updateRequest.getLastName());
         toUpdate.setPosition(updateRequest.getPosition());
         toUpdate.setPartyAffiliation(updateRequest.getPartyAffiliation());

         candidateRepository.save(toUpdate);

         return "User successfully updated";
      } else {

         return "User not found with ID: " + id;
      }
   }
   @CacheEvict(value = "single candidate", allEntries = true)
   public void deleteById(long CandidateId) {

      candidateRepository.deleteById(CandidateId);
   }

   public boolean authenticateCandidate(String username, String password) {
      return false;
   }
}
