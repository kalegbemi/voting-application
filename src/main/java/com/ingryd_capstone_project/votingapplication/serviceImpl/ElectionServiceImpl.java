package com.ingryd_capstone_project.votingapplication.serviceImpl;

import com.ingryd_capstone_project.votingapplication.dto.ElectionRequest;
import com.ingryd_capstone_project.votingapplication.dto.HttpResponse;
import com.ingryd_capstone_project.votingapplication.enums.Status;
import com.ingryd_capstone_project.votingapplication.model.Election;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

public interface ElectionServiceImpl {
    ResponseEntity<String> findElectionById(Long id);
    ResponseEntity<List<Election>> findElectionByStatus(Status status);
    ResponseEntity<Election> findElectionByTitle(String title);
    ResponseEntity<List<Election>> findAllElection();
    ResponseEntity<Election> updateElectionById(Long id, ElectionRequest request);

    ResponseEntity<Election> createElection(ElectionRequest request);

    ResponseEntity<HttpResponse> deleteElectionById(Long id) throws URISyntaxException;


}
