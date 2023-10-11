package org.example.command.employee.create;



import org.example.entities.employee.Employee;

import org.example.entities.role.Role;
import org.example.entities.user.CustomUser;
import org.example.enums.RoleType;
import org.example.repositories.employee.EmployeeCommandRepository;

import org.example.repositories.role.RoleQueryRepository;
import org.example.security.authentication.AuthService;
import org.example.valueobjects.EmailAddress;
import org.example.valueobjects.Password;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


class CreateEmployeeCommandHandlerTest {

    @Mock
    private AuthService authService;

    @Mock
    private EmployeeCommandRepository employeeCommandRepository;

    @Mock
    private RoleQueryRepository roleQueryRepository;

    private CreateEmployeeCommandHandler createEmployeeCommandHandler;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        createEmployeeCommandHandler = new CreateEmployeeCommandHandler(authService, employeeCommandRepository, roleQueryRepository);
    }



    @Test
    void shouldCreateEmployee() {
        CreateEmployeeCommand command = new CreateEmployeeCommand("Aleksander",
                "Tester",
                new EmailAddress("test@gmail.com"),
                new Password("Password123456!"));

        CustomUser user = new CustomUser();
        when(authService.registerUser(command)).thenReturn(user);

        Role mockRole = new Role();
        when(roleQueryRepository.findByName(RoleType.EMPLOYEE)).thenReturn(Optional.of(mockRole));

        createEmployeeCommandHandler.execute(command);

        verify(authService, times(1)).registerUser(command);
        verify(roleQueryRepository, times(1)).findByName(RoleType.EMPLOYEE);
        assertEquals(Set.of(mockRole), user.getRoles());

        Employee expectedEmployee = new Employee();
        expectedEmployee.setUser(user);
        verify(employeeCommandRepository, times(1)).save(expectedEmployee);


    }



    @Test
    void shouldSupportCreateEmployeeCommand() {
        assertTrue(createEmployeeCommandHandler.supportsOperation(CreateEmployeeCommand.class.getSimpleName()));
    }




}