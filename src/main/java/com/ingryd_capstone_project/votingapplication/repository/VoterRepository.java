package com.ingryd_capstone_project.votingapplication.repository;

import com.ingryd_capstone_project.votingapplication.model.Voter;
import com.ingryd_capstone_project.votingapplication.request.UserRegisterationRequest;
import com.ingryd_capstone_project.votingapplication.request.VoterUpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
    Voter findByUsername(String userName);
    Voter findVoterByFirstName(String firstName);


}
