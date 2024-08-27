package com.example.spring.domain.auth.exception;

import com.example.spring.global.error.exception.ErrorCode;
import com.example.spring.global.error.exception.PageException;

public class ExpiredTokenException extends PageException {

    public static final PageException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
