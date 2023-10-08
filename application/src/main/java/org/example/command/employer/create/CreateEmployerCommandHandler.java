package org.example.command.employer.create;

import org.example.IRequestHandler;
import org.example.entities.employer.Employer;
import org.example.entities.role.Role;
import org.example.entities.user.CustomUser;
import org.example.enums.RoleType;
import org.example.repositories.employer.EmployerCommandRepository;
import org.example.repositories.role.RoleQueryRepository;
import org.example.security.authentication.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CreateEmployerCommandHandler implements IRequestHandler<CreateEmployerCommand> {

    private  final AuthService authService;

    private  final EmployerCommandRepository employerCommandRepository;

    private  final RoleQueryRepository roleQueryRepository;

    public CreateEmployerCommandHandler(AuthService authService, EmployerCommandRepository employerCommandRepository, RoleQueryRepository roleQueryRepository) {
        this.authService = authService;
        this.employerCommandRepository = employerCommandRepository;
        this.roleQueryRepository = roleQueryRepository;
    }

    @Override
    public boolean supportsOperation(Object operation) {
        return CreateEmployerCommand.class.getSimpleName().equals(operation);
    }

    @Override
    @Transactional
    public void execute(CreateEmployerCommand command) {
        CustomUser user = this.authService.registerUser(command);
        Optional<Role> role = roleQueryRepository.findByName(RoleType.EMPLOYER);
        role.ifPresent(value -> user.setRoles(Set.of(value)));
        Employer employer = new Employer();
        employer.setUser(user);
        employerCommandRepository.save(employer);

    }
}
