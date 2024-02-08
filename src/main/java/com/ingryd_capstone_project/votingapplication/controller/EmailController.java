package com.ingryd_capstone_project.votingapplication.controller;

import com.ingryd_capstone_project.votingapplication.dto.CandidateEmailDetails;
import com.ingryd_capstone_project.votingapplication.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/mail")
//public class EmailController {
//    @Autowired
//    private EmailService emailService;
//
//    @GetMapping("/send")
//    public String sendmail(){
//        CandidateEmailDetails details = CandidateEmailDetails.builder()
//                .to("kydjams@yahoo.com")
//                .party("APC")
//                .name("Kayode J Alegbemi")
//                .position("PRESIDENCY")
//                .role("Candidate")
//                .build();
//        emailService.sendCandidateMessage(details);
//        return "message sent successfully";
//    }
//}
