package com.example.spring.domain.user.exception;

import com.example.spring.global.error.exception.ErrorCode;
import com.example.spring.global.error.exception.PageException;

public class UserNotFoundException extends PageException {

    public static final PageException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
