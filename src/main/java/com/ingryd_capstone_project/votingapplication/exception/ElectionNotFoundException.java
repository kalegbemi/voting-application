package com.ingryd_capstone_project.votingapplication.exception;

public class ElectionNotFoundException extends RuntimeException {

    public ElectionNotFoundException(String message) {
        super(message);
    }
}
