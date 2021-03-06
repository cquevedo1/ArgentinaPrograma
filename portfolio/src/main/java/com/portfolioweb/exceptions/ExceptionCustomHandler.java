package com.portfolioweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolioweb.models.dtos.ErrorResponse;

public class ExceptionCustomHandler {

    private static String messageDelete;

    public static ResponseEntity<?> throwError(HttpStatus status, String message) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(status.name())
                .code(String.valueOf(status.value()))
                .message(message)
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }

    public static ResponseEntity<?> throwErrorNotFound(HttpStatus status, String id) {
        messageDelete = "Id : " + id + " no existe.";
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(status.name())
                .code(String.valueOf(status.value()))
                .message(messageDelete)
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }
}
