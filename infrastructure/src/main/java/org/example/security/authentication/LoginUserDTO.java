package org.example.security.authentication;

public record LoginUserDTO(
        String emailAddress,
        String password
) {
}
