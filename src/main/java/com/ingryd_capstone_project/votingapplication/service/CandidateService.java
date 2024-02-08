package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.model.Candidate;
import com.ingryd_capstone_project.votingapplication.model.Voter;
import com.ingryd_capstone_project.votingapplication.repository.CandidateRepository;
import com.ingryd_capstone_project.votingapplication.request.CandidateUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CandidateService {

   private final CandidateRepository candidateRepository;

   public Candidate getCandidateById(long id) {

      return candidateRepository.findById(id).orElseThrow();
   }
   @CacheEvict(value = "allCandidate", allEntries = true)
   public Candidate saveCandidate(Candidate candidate) {
      Candidate candidate1 = new Candidate();
      candidate1.setFirstName(candidate.getFirstName());
      candidate1.setLastName(candidate.getLastName());
      candidate1.setPartyAffiliation(candidate.getPartyAffiliation());
      candidate1.setPosition(candidate.getPosition());
      return candidateRepository.save(candidate1);
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

//   public Candidate getCandidateById(long id) {
//
//      return candidateRepository.findById(id).orElse(null);
//   }

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
   public void deleteById(long CandidateId) {
      candidateRepository.deleteById(CandidateId);
   }
}
