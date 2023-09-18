package org.example.command.employer.create;

import org.example.IRequestHandler;
import org.example.entities.employer.Employer;
import org.example.entities.role.Role;
import org.example.entities.user.CustomUser;
import org.example.enums.RoleType;
import org.example.repositories.employer.EmployerCommandRepository;
import org.example.security.authentication.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CreateEmployerCommandHandler implements IRequestHandler<CreateEmployerCommand> {

    private  final AuthService authService;

    private  final EmployerCommandRepository employerCommandRepository;

    public CreateEmployerCommandHandler(AuthService authService, EmployerCommandRepository employerCommandRepository) {
        this.authService = authService;
        this.employerCommandRepository = employerCommandRepository;
    }

    @Override
    public boolean supportsOperation(Object operation) {
        return CreateEmployerCommand.class.equals(operation.getClass());
    }

    @Override
    @Transactional
    public void execute(CreateEmployerCommand command) {
        CustomUser user = this.authService.registerUser(command);
        user.setRoles(Set.of(RoleType.EMPLOYER));
        Employer employer = new Employer();
        employer.setId(UUID.randomUUID());
        employer.setUser(user);
        employerCommandRepository.save(employer);

    }
}
