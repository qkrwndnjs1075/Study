package com.example.spring.global.error;

import com.example.spring.global.error.exception.PageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PageException.class)
    public ResponseEntity<>
}
