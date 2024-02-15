package com.ingryd_capstone_project.votingapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "candidate_table")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade =CascadeType.ALL)
    private Voter voter;

    @ManyToOne(cascade =CascadeType.ALL)
    private Vote vote;

    private String firstName;

    private String lastName;

    private String partyAffiliation;

    private String position;

    public Candidate orElse(Object o) {
        return null;
    }
}
