package com.imaginary_store.registration.utility;

import com.imaginary_store.registration.exceptions.EmptyRequestBodyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import utility.ErrorInfo;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RegistrationApplicationExceptionHandler {

    @ExceptionHandler(EmptyRequestBodyException.class)
    public ResponseEntity<ErrorInfo> irregularRequestBodyHandler() {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode("");
        errorInfo.setErrorMessage("");
        errorInfo.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
