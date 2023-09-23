package org.example.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@Service
public class ErrorBuilder {

    private String errorMessage = "BAD REQUEST";

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private final Map<String, String> fieldErrors = new HashMap<>();


    public void addErrorField(String field, String message) {
        this.fieldErrors.put(field, message);
    }


    public boolean containsErrors() {
        return !this.fieldErrors.isEmpty();
    }



}
