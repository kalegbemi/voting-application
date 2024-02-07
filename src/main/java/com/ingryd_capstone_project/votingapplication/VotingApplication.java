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

	@Bean
	public JavaMailSender javaMailSender(){
		return new JavaMailSenderImpl();
	}
	@Bean
	public MailProperties mailProperties(){
		return new MailProperties();
	}

	public static void main(String[] args) {

		SpringApplication.run(VotingApplication.class, args);
	}
}
