package org.example.command.employer.create;

import org.example.ICommandValidator;
import org.example.exceptions.ErrorBuilder;
import org.example.repositories.user.UserQueryRepository;
import org.example.valueobjects.EmailAddress;
import org.springframework.stereotype.Service;

@Service
public class CreateEmployerCommandValidator implements ICommandValidator<CreateEmployerCommand> {

    private final UserQueryRepository userQueryRepository;


    public CreateEmployerCommandValidator(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }

    @Override
    public void validate(CreateEmployerCommand command, ErrorBuilder errorBuilder) {
        validateIfEmailIsAlreadyTaken(command.getEmailAddress(), errorBuilder);
    }



    @Override
    public boolean supportsCommand(Object command) {
        return CreateEmployerCommand.class.getSimpleName().equals(command);
    }


    public void validateIfEmailIsAlreadyTaken(EmailAddress emailAddress, ErrorBuilder errorBuilder) {
        var user = userQueryRepository.findByEmailAddress(emailAddress);

        if(user.isPresent()) {
            errorBuilder.addErrorField("emailAddress", "Email is already taken");
        }

    }
}
