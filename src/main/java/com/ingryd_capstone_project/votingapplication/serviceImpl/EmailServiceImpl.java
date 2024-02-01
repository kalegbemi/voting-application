package com.ingryd_capstone_project.votingapplication.serviceImpl;

import com.ingryd_capstone_project.votingapplication.dto.CandidateEmailDetails;

public interface EmailServiceImpl {

    void sendVoterMessage(String to, String name, String role);
    void sendCandidateMessage(CandidateEmailDetails details);
}
