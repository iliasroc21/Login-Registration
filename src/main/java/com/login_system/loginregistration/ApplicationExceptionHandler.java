package com.login_system.loginregistration;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.login_system.loginregistration.exception.EmailStateException;
import com.login_system.loginregistration.exception.ErrorResponse;
import com.login_system.loginregistration.exception.TokenStateException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({EmailStateException.class , TokenStateException.class})
    public ResponseEntity<ErrorResponse> handleEmailStateException(RuntimeException ex){
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }




    
}
