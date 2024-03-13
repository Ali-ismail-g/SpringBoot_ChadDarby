package com.luv2code.restAPI.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice    //to make exception handler act as a global handler
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){ //exc is type of exception to catch/handle
        //create new error
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return error with httpMsg&Status (response entity)
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){ //exc is a generic type of exception to catch/handle
        //create new error
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return error with httpMsg&Status (response entity)
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
