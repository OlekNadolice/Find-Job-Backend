package org.example.command.user.create;

import org.example.IRequestHandler;
import org.example.repositories.User.UserCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements IRequestHandler<CreateUserCommand> {
    private final UserCommandRepository userCommandRepository;

    @Autowired
    public CreateUserCommandHandler(UserCommandRepository userCommandRepository) {
        this.userCommandRepository = userCommandRepository;
    }

    @Override
    public void execute(CreateUserCommand command) {

    }

    @Override
    public boolean supportsOperation(Object command) {
        return CreateUserCommand.class.equals(command);
    }
}
