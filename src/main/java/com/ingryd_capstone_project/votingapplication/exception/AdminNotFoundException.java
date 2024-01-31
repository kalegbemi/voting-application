package com.ingryd_capstone_project.votingapplication.exception;

public class AdminNotFoundException extends RuntimeException{
    public AdminNotFoundException(String message) {
        super(message);
    }
}
