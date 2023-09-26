package org.example.command.employer.create;

import org.example.ICommandValidator;
import org.example.exceptions.ErrorBuilder;
import org.example.repositories.user.UserQueryRepository;

public class CreateEmployerCommandValidator implements ICommandValidator<CreateEmployerCommand> {

    private UserQueryRepository userQueryRepository;


    public CreateEmployerCommandValidator(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }

    @Override
    public void validate(CreateEmployerCommand command, ErrorBuilder errorBuilder) {
        validateIfEmailIsAlreadyTaken(command.getEmailAddress(), errorBuilder);
    }



    @Override
    public boolean supportsCommand(Object command) {
        return command.getClass().equals(CreateEmployerCommand.class);
    }


    public void validateIfEmailIsAlreadyTaken(String emailAddress, ErrorBuilder errorBuilder) {
        var user = userQueryRepository.findByEmailAddress(emailAddress);

        if(user.isPresent()) {
            errorBuilder.addErrorField("emailAddress", "Email is already taken");
        }

    }
}
