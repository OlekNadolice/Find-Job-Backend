package org.example.command.employee.create;

import org.example.IRequestHandler;
import org.example.command.employer.create.CreateEmployerCommand;
import org.example.entities.employee.Employee;

import org.example.entities.role.Role;
import org.example.entities.user.CustomUser;
import org.example.enums.RoleType;
import org.example.repositories.employee.EmployeeCommandRepository;

import org.example.repositories.role.RoleQueryRepository;
import org.example.security.authentication.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class CreateEmployeeCommandHandler implements IRequestHandler<CreateEmployeeCommand> {

    private  final AuthService authService;

    private  final EmployeeCommandRepository employeeCommandRepository;

    private  final RoleQueryRepository roleQueryRepository;

    public CreateEmployeeCommandHandler(AuthService authService, EmployeeCommandRepository employeeCommandRepository, RoleQueryRepository roleQueryRepository) {
        this.authService = authService;
        this.employeeCommandRepository = employeeCommandRepository;
        this.roleQueryRepository = roleQueryRepository;
    }

    @Override
    public boolean supportsOperation(Object operation) {
        return CreateEmployeeCommand.class.getSimpleName().equals(operation);
    }


    @Override
    @Transactional
    public void execute(CreateEmployeeCommand command) {
        CustomUser user = this.authService.registerUser(command);
        Optional<Role> role = roleQueryRepository.findByName(RoleType.EMPLOYEE);
        role.ifPresent(value -> user.setRoles(Set.of(value)));
        Employee employee = new Employee();
        employee.setUser(user);
        employeeCommandRepository.save(employee);

    }
}
