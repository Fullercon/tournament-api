package com.reemteam.tournamentapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "That email address is already in use.")
public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(){}

    public EmailAlreadyInUseException(String message) {
        super(message);
    }

}
