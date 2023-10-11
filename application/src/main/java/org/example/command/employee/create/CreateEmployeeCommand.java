package org.example.command.employee.create;

import lombok.NoArgsConstructor;
import org.example.IRequest;
import org.example.security.authentication.RegisterUserDTO;
import org.example.valueobjects.EmailAddress;
import org.example.valueobjects.Password;

@NoArgsConstructor
public class CreateEmployeeCommand extends RegisterUserDTO implements IRequest {


    public CreateEmployeeCommand(String firstName, String lastName, EmailAddress emailAddress, Password password) {
        super(firstName, lastName, emailAddress, password);
    }
}
