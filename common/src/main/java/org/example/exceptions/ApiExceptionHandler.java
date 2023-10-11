package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleApiRequestException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> errors = new HashMap<>();
        for (var fieldError : fieldErrors) {
            var key = formatFieldError(fieldError.getField());
            var value = fieldError.getDefaultMessage();
            errors.put(key, value);
        }
        return ApiError.buildErrorResponse("Bad request", HttpStatus.BAD_REQUEST, errors);
    }




    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(RuntimeException ex) {
        return ApiError.buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> validationRequestException(ValidationException ex) {
    return  ApiError.buildErrorResponse(ex.errorBuilder().getErrorMessage(), ex.errorBuilder().getHttpStatus(), ex.errorBuilder().getFieldErrors());
    }


    public String formatFieldError(String field) {

        if(field.contains(".")) {
         int index =   field.indexOf(".");
         return field.substring(0, index);
        }

        return field;
    }

}
