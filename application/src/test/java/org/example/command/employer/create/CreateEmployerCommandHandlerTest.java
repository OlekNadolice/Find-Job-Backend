package org.example.command.employer.create;

import org.example.entities.employer.Employer;
import org.example.entities.role.Role;
import org.example.entities.user.CustomUser;
import org.example.enums.RoleType;
import org.example.repositories.employer.EmployerCommandRepository;
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


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateEmployerCommandHandlerTest {

    @Mock
    private AuthService authService;

    @Mock
    private EmployerCommandRepository employerCommandRepository;

    @Mock
    private RoleQueryRepository roleQueryRepository;

    private CreateEmployerCommandHandler createEmployerCommandHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        createEmployerCommandHandler = new CreateEmployerCommandHandler(authService, employerCommandRepository, roleQueryRepository);
    }


    @Test
    void shouldCreateEmployer() {
        CreateEmployerCommand command = new CreateEmployerCommand("Aleksander",
                "Tester",
                new EmailAddress("test@gmail.com"),
                new Password("Password123456!"));

        CustomUser user = new CustomUser();
        when(authService.registerUser(command)).thenReturn(user);

        Role mockRole = new Role();
        when(roleQueryRepository.findByName(RoleType.EMPLOYER)).thenReturn(Optional.of(mockRole));

        createEmployerCommandHandler.execute(command);

        verify(authService, times(1)).registerUser(command);
        verify(roleQueryRepository, times(1)).findByName(RoleType.EMPLOYER);
        assertEquals(Set.of(mockRole), user.getRoles());

        Employer expectedEmployer = new Employer();
        expectedEmployer.setUser(user);
        verify(employerCommandRepository, times(1)).save(expectedEmployer);


    }


    @Test
    void shouldSupportCreateEmployerCommand() {
        assertTrue(createEmployerCommandHandler.supportsOperation(CreateEmployerCommand.class.getSimpleName()));
    }
}