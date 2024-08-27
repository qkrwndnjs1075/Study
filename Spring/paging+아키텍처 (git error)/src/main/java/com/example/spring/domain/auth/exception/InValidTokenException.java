package com.example.spring.domain.auth.exception;

import com.example.spring.global.error.exception.ErrorCode;
import com.example.spring.global.error.exception.PageException;

public class InValidTokenException extends PageException {

    public static final PageException EXCEPTION = new InValidTokenException();

    public InValidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
}
