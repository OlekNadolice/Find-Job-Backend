package org.example.dto.user;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Email address is required")
        String emailAddress,

        @NotBlank(message = "Password is required")
        String password
) {
}