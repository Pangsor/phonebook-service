package com.walatech.phonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateContactException extends RuntimeException{

    private String message;

    public DuplicateContactException(String message){
        super(message);
    }
}
