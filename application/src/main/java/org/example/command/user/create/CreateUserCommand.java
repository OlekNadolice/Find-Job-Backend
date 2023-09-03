package org.example.command.user.create;

import jakarta.validation.constraints.NotBlank;
import org.example.IRequest;

public record CreateUserCommand(
        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Email address is required")
        String emailAddress,

        @NotBlank(message = "Password is required")
        String password
) implements IRequest {
}