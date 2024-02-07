//package com.ingryd_capstone_project.votingapplication.repository;
//
//import com.ingryd_capstone_project.votingapplication.model.Voter;
//import com.ingryd_capstone_project.votingapplication.request.UserRegisterationRequest;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface VoterRepository extends JpaRepository<Voter, Long> {
//    Voter findByVoterId(long voterId);
//
//    Voter findByUsername(String username);
//
//    Voter createVoter(UserRegisterationRequest voter);
//
//    Voter updateVoter();
//}
