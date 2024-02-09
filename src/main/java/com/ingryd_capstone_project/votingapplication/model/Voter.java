package com.ingryd_capstone_project.votingapplication.model;

import com.ingryd_capstone_project.votingapplication.enums.Role;
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
@Table(name = "voter_table")
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade =CascadeType.ALL)
    private Vote vote;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.VOTER;

    public String setPassword() {
        return setPassword();
    }
}
