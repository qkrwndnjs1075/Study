package com.example.main.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EntryException extends RuntimeException{
    private final ErrorCode errorCode;
}
