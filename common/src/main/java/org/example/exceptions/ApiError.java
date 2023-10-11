package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiError {

    private static  final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static ResponseEntity<Object> buildErrorResponse(String message, HttpStatus httpStatus) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().format(formatter));
        body.put("message", message);
        return new ResponseEntity<>(body, httpStatus);
    }

    public static ResponseEntity<Object> buildErrorResponse(String message, HttpStatus httpStatus, Object errors) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().format(formatter));
        body.put("message", message);
        body.put("errors", errors);
        return new ResponseEntity<>(body, httpStatus);
    }
}
