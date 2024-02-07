package com.ingryd_capstone_project.votingapplication.request;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
public class VoterUpdateRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
