package com.skypro.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class IllegalNumberException extends RuntimeException {

    public IllegalNumberException(String message) {
        super(message);
    }
}
