package org.example.command.user.create;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.example.IRequest;

import java.util.UUID;

@Getter
public class CreateUserCommand implements IRequest {

    @NotBlank(message = "First name is required")
    private final String firstName;

    @NotBlank(message = "Last name is required")
    private final String lastName;

    @NotBlank(message = "Email address is required")
    private final String emailAddress;

    @NotBlank(message = "Password is required")
    private final String password;

    private final UUID id;


    public CreateUserCommand(String firstName, String lastName, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.id = UUID.randomUUID();
    }
}
