package com.SchoolDetails.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler  {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceException(ResourceNotFoundException exp)
    {
        return new ResponseEntity<>(exp.getMessage(),HttpStatus.NOT_FOUND);
    }

}
