//package com.ingryd_capstone_project.votingapplication.service;
//
//import com.ingryd_capstone_project.votingapplication.dto.CandidateEmailDetails;
//import com.ingryd_capstone_project.votingapplication.serviceImpl.EmailServiceImpl;
//import com.ingryd_capstone_project.votingapplication.util.MessageUtil;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.mail.MailProperties;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class EmailService implements EmailServiceImpl {
//
//    public static final String UTF_8_ENCODING = "UTF-8";
//    public static final String SUBJECT = "NOTIFICATION OF REGISTRATION";
//
//    private final JavaMailSender javaMailSender;
//    private final MailProperties mailProperties;
//
//
//
//    @Override
//    public void sendVoterMessage(String to, String name, String role) {
//        log.info("sending email to {}",name);
//        try{
//            MimeMessage message = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, UTF_8_ENCODING);
//            helper.setFrom(mailProperties.getUsername());
//            helper.setTo(to);
//            helper.setSubject(SUBJECT);
//            helper.setText(MessageUtil.getVoterMessage(to,name,role));
//            javaMailSender.send(message);
//        }catch (MessagingException e){
//            log.error(e.getMessage());
//        }
//
//    }
//
//    @Override
//    public void sendCandidateMessage(CandidateEmailDetails details) {
//        log.info("sending email to candidate {}",details.getName());
//        try{
//            MimeMessage message = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, UTF_8_ENCODING);
//            helper.setFrom(mailProperties.getUsername());
//            helper.setTo(details.getTo());
//            helper.setSubject(SUBJECT);
//            helper.setText(MessageUtil.getCandidateMessage(details));
//            javaMailSender.send(message);
//        }catch (MessagingException e){
//            log.error(e.getMessage());
//        }
//
//    }
//}
