package com.SchoolDetails.GlobalExceptionHandler;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String message)
    {
         super(message);
    }
}
