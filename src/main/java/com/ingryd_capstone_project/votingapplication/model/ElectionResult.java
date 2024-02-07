package com.ingryd_capstone_project.votingapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ElectionResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "election_id")
    private Election election;

    @ManyToOne
    private Candidate candidate;

    @OneToMany
    private List<Vote> vote;

    private static Long totalResult;

    private static Long totalVote;


}
