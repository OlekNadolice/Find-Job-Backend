package org.example.command.user.delete;

import org.example.IRequestHandler;
import org.example.command.company.delete.DeleteCompanyCommand;
import org.example.repositories.User.UserCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserCommandHandler implements IRequestHandler<DeleteUserCommand> {

    private final UserCommandRepository userCommandRepository;

    @Autowired
    public DeleteUserCommandHandler(UserCommandRepository userCommandRepository) {
        this.userCommandRepository = userCommandRepository;
    }

    @Override
    public Object execute(DeleteUserCommand command) {
        return  null;
    }

    @Override
    public boolean supportsOperation(Object command) {
        return DeleteCompanyCommand.class.equals(command);
    }
}
