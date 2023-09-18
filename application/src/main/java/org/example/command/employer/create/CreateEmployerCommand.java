package org.example.command.employer.create;

import org.example.IRequest;

import org.example.security.authentication.RegisterUserDTO;

public class CreateEmployerCommand extends RegisterUserDTO implements IRequest {

    public CreateEmployerCommand(String firstName, String lastName, String emailAddress, String password) {
        super(firstName, lastName, emailAddress, password);
    }
}
