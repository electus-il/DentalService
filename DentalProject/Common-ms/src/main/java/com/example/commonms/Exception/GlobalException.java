package com.example.commonms.Exception;

import jakarta.servlet.http.PushBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalException {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> patientNotFoundHandler(PatientNotFoundException patientNotFoundException){
        Map<String,String> error = new HashMap<>();
        error.put("error message : " , patientNotFoundException.getLocalizedMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(error)
                .iat(LocalDateTime.now())
                .statusCode(NOT_FOUND.value())
                .build();
        return ResponseEntity.status(NOT_FOUND).body(errorResponse);

    }

    @ExceptionHandler(PatientAlreadyException.class)
    public ResponseEntity<ErrorResponse> PatientAlreadyExceptionHandle(PatientAlreadyException patientAlreadyException){
        Map<String,String> error = new HashMap<>();
        error.put("error message : " , patientAlreadyException.getLocalizedMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .iat(LocalDateTime.now())
                .statusCode(CONFLICT.value())
                .message(error)
                .build();
        return ResponseEntity.status(CONFLICT).body(errorResponse);
    }




}
