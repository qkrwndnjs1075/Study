package com.example.spring.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageException extends RuntimeException{
    private final ErrorCode errorCode;
}
