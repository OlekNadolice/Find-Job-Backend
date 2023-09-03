package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiError {

    public static ResponseEntity<Object> buildErrorResponse(String message, HttpStatus httpStatus) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        return new ResponseEntity<>(body, httpStatus);
    }

    public static ResponseEntity<Object> buildErrorResponse(String message, HttpStatus httpStatus, Object errors) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        body.put("errors", errors);
        return new ResponseEntity<>(body, httpStatus);
    }
}
