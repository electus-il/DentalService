package com.example.commonms.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    PATIENT_NOT_FOUND_EXCEPTION("Patient not found"),
    PATIENT_ALREADY_EXCEPTION("Patient Already exception");


    private final String message;

    public String format(Object... args) {
        return String.format(this.message, args);
    }

}