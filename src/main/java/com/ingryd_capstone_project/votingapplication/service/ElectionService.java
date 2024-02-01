package com.ingryd_capstone_project.votingapplication.service;

import com.ingryd_capstone_project.votingapplication.dto.ElectionRequest;
import com.ingryd_capstone_project.votingapplication.dto.HttpResponse;
import com.ingryd_capstone_project.votingapplication.enums.Status;
import com.ingryd_capstone_project.votingapplication.exception.ElectionNotFoundException;
import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.repository.ElectionRepository;
import com.ingryd_capstone_project.votingapplication.serviceImpl.ElectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ElectionService implements ElectionServiceImpl {

    private final ElectionRepository electionRepo;

    @Override
    public ResponseEntity<String> findElectionById(Long id) {
        Election election = electionRepo.findById(id).orElseThrow(
                ()->new ElectionNotFoundException("There is no record of election with this id."));

        return ResponseEntity.ok("Election created successfully\n"+election.getTitle());
    }

    @Override
    public ResponseEntity<List<Election>> findElectionByStatus(Status status) {
        List<Election> election = electionRepo.findByStatus(status);
        return ResponseEntity.ok(election);
    }

    @Override
    public ResponseEntity<Election> findElectionByTitle(String title) {
        Election election = electionRepo.findByTitle(title);
        return ResponseEntity.ok(election);
    }

    @Override
    public ResponseEntity<List<Election>> findAllElection() {
        return ResponseEntity.ok(electionRepo.findAll());
    }

    @Override
    public ResponseEntity<Election> updateElectionById(Long id, ElectionRequest request) {
        Election election2Update = electionRepo.findById(id).orElseThrow(
                ()->new ElectionNotFoundException("not found"));
        election2Update.setTitle(request.getTitle());
        election2Update.setStartDate(request.getStartDate());
        election2Update.setEndDate(request.getEndDate());

        return ResponseEntity.ok(electionRepo.save(election2Update));

    }

    @Override
    public ResponseEntity<Election> createElection(ElectionRequest request) {
        Election election = new Election();

                election.setTitle(request.getTitle());
                election.setStartDate(request.getStartDate());
                election.setEndDate(request.getEndDate());

        electionRepo.save(election);

        return new ResponseEntity<>(election, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<HttpResponse> deleteElectionById(Long id) throws URISyntaxException {
        if (!electionRepo.existsById(id)){
            throw new ElectionNotFoundException("Election not found");
        }

        URI uri = new URI("votemanagement",
                "http",
                "localhost",
                8080,
                "/election/deleteelectionbyid",
                "id",
                "");
        electionRepo.deleteById(id);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK.name())
                        .requestMethod("getMapping")
                        .path(uri.getPath())
                        .statusCode(HttpStatus.OK.value())
                        .message("Election with ID "+id+", has been successfully deleted")
                        .build()
        );
    }
}
