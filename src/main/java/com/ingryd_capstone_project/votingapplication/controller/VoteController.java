//package com.ingryd_capstone_project.votingapplication.controller;
//
//import com.ingryd_capstone_project.votingapplication.model.Vote;
//import com.ingryd_capstone_project.votingapplication.service.VoteService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/votes")
//public class VoteController {
//
//    private VoteService voteService;
//
//    @PostMapping("")
//    //public ResponseEntity<Voter>
//
//  @GetMapping("/election/{electionId}")
//    public ResponseEntity<Vote> getElectionById(@PathVariable long electionId) {
//      return voteService.getElectionById(electionId);
//  }
//
//  @GetMapping("/voter/{voterId}")
//    public ResponseEntity<Vote> getVoteByVoterId(@PathVariable long voterId) {
//      return voteService.getVoteByVoterId(voterId);
//  }
//
//
//}
