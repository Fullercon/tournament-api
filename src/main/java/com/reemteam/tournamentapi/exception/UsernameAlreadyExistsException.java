package com.reemteam.tournamentapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "That username already exists.")

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(){}

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }

}
