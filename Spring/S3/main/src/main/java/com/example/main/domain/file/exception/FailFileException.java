package com.example.main.domain.file.exception;


import com.example.main.global.error.exception.EntryException;
import com.example.main.global.error.exception.ErrorCode;

public class FailFileException extends EntryException {

    public static final EntryException EXCEPTION = new FailFileException();

    private FailFileException(){
        super(ErrorCode.FAIL_FILE);
    }
}
