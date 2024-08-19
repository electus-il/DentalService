package com.example.commonms.Exception;

public class PatientAlreadyException extends RuntimeException{
    public PatientAlreadyException(ErrorMessage errorMessage , Object... args) {
        super(String.format(errorMessage.getMessage() , args));
    }
}
