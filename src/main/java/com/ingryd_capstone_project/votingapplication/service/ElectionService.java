package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.dto.ElectionRequest;
import com.ingryd_capstone_project.votingapplication.enums.Status;
import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.repository.ElectionRepository;
import com.ingryd_capstone_project.votingapplication.serviceImpl.ElectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ElectionService implements ElectionServiceImpl {

    private final ElectionRepository electionRepo;

    @Override
    public ResponseEntity<Election> findElectionById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Election> findElectionByStatus(Status status) {
        return null;
    }

    @Override
    public ResponseEntity<Election> findElectionByTitle(String title) {
        return null;
    }

    @Override
    public ResponseEntity<List<Election>> findAllElection() {
        return null;
    }

    @Override
    public ResponseEntity<Election> updateElectionById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Election> createElection(ElectionRequest request) {
        Election election = Election.builder()
                .title(request.getTitle())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return new ResponseEntity<>(election, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<String> deleteElectionById(Long id) {
        return null;
    }
}
