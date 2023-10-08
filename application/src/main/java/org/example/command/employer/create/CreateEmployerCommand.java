package org.example.command.employer.create;

import lombok.NoArgsConstructor;
import org.example.IRequest;

import org.example.security.authentication.RegisterUserDTO;

@NoArgsConstructor()
public class CreateEmployerCommand extends RegisterUserDTO implements IRequest {

    public CreateEmployerCommand(String firstName, String lastName, String emailAddress, String password) {
        super(firstName, lastName, emailAddress, password);
    }
}
