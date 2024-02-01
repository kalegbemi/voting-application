package com.ingryd_capstone_project.votingapplication.controller;

import com.ingryd_capstone_project.votingapplication.dto.ElectionRequest;
import com.ingryd_capstone_project.votingapplication.dto.HttpResponse;
import com.ingryd_capstone_project.votingapplication.enums.Status;
import com.ingryd_capstone_project.votingapplication.model.Election;
import com.ingryd_capstone_project.votingapplication.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/election")
public class ElectionController {

    private final ElectionService electionService;

    @GetMapping("/all")
    public ResponseEntity<List<Election>> getAllElections(){
        return electionService.findAllElection();
    }

    @GetMapping("/getById")
    public ResponseEntity<String> findById(@RequestParam("id") Long id){
        return electionService.findElectionById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Election> saveElection(@RequestBody ElectionRequest request){
        return electionService.createElection(request);
    }

    @GetMapping("/getByStatus")
    public ResponseEntity<List<Election>> findElectionByStatus(@RequestParam("status") Status status){
        return electionService.findElectionByStatus(status);
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<Election> findElectionByTitle(@RequestParam("title") String title){
        return electionService.findElectionByTitle(title);
    }

    @PutMapping("/updateElection/{id}")
    public ResponseEntity<Election> updateElectionById(@PathVariable Long id, @RequestBody ElectionRequest request){
        return electionService.updateElectionById(id, request);
    }

    @DeleteMapping("/deleteelectionbyid/{id}")
    public ResponseEntity<HttpResponse> deleteElectionById(@PathVariable Long id) throws URISyntaxException {
        return electionService.deleteElectionById(id);
    }


    }
