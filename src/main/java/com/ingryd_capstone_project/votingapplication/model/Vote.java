package com.ingryd_capstone_project.votingapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @ManyToOne
   private Voter voter;

    @ManyToOne
   private Candidate candidate;

    @ManyToOne
   private Election election;

    private LocalDateTime startTime;

    private LocalDateTime endTime;






}
