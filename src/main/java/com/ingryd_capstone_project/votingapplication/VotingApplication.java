package com.ingryd_capstone_project.votingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@EnableCaching
public class VotingApplication {

	public static void main(String[] args) {

		SpringApplication.run(VotingApplication.class, args);

	}
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setPort(465); // Or the appropriate port for your mail server
//		mailSender.setUsername("physayoemma@gmail.com");
//		mailSender.setPassword("lfzqtcbiwakashgg");
//		//mailSender.setProtocol("");
//		// More configurations as needed

		return mailSender;
	}


}
