package com.example.spring.domain.user.exception;

import com.example.spring.global.error.exception.PageException;

public class NotAuthenticationException extends RuntimeException {



    public NotAuthenticationException(String message){
        super(message);
    }
}
