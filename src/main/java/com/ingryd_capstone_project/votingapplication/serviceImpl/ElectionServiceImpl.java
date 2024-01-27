package com.ingryd_capstone_project.votingapplication.serviceImpl;

import com.ingryd_capstone_project.votingapplication.dto.ElectionRequest;
import com.ingryd_capstone_project.votingapplication.enums.Status;
import com.ingryd_capstone_project.votingapplication.model.Election;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ElectionServiceImpl {
    ResponseEntity<Election> findElectionById(Long id);
    ResponseEntity<Election> findElectionByStatus(Status status);
    ResponseEntity<Election> findElectionByTitle(String title);
    ResponseEntity<List<Election>> findAllElection();
    ResponseEntity<Election> updateElectionById(Long id);

    ResponseEntity<Election> createElection(ElectionRequest request);

    ResponseEntity<String> deleteElectionById(Long id);


}
