package com.example.hospitalms.config;

import com.example.hospitalms.exception.BadRequestException;
import com.example.hospitalms.exception.DataNotFoundException;
import com.example.hospitalms.exception.RequestValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<String> dataNotFound(DataNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(value = {RequestValidationException.class})
    public ResponseEntity<String> requestValidation(RequestValidationException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<String> authorizationFailed(BadRequestException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
