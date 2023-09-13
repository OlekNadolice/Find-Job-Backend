package org.example.security.jwt;

public class InvalidCredentialsException extends  RuntimeException{

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
