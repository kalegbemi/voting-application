package com.ingryd_capstone_project.votingapplication.model;

import com.ingryd_capstone_project.votingapplication.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "voter_table")
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade =CascadeType.ALL)
    private Vote vote;

    private String firstName;

    private String lastName;

    private String fullName;

    private String username;

    private String password;

    //boolean registered;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public Voter(Vote vote, String firstName, String lastName, String username, String password, Role role) {
        this.vote = vote;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.fullName = firstName + " "+ lastName;
        this.role = Role.VOTER;
    }
}
