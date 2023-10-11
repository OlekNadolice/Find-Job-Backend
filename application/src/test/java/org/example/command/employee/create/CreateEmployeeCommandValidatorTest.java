package org.example.command.employee.create;


import org.example.entities.user.CustomUser;
import org.example.exceptions.ErrorBuilder;
import org.example.repositories.user.UserQueryRepository;
import org.example.valueobjects.EmailAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CreateEmployeeCommandValidatorTest {

    @Mock
    private UserQueryRepository userQueryRepository;

    private CreateEmployeeCommandValidator createEmployeeCommandValidator;


    private ErrorBuilder errorBuilder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        createEmployeeCommandValidator = new CreateEmployeeCommandValidator(userQueryRepository);
        errorBuilder = new ErrorBuilder();

    }


    @Test
    void shouldReturnErrorWhenRegisteringEmployeeWithAlreadyTakenEmail() {
        CustomUser customUser = new CustomUser();
        EmailAddress address = new EmailAddress("Test123@gmail.com");
        when(userQueryRepository.findByEmailAddress(address)).thenReturn(Optional.of(customUser));
        createEmployeeCommandValidator.validateIfEmailIsAlreadyTaken(address, errorBuilder);
        assertTrue(errorBuilder.containsErrors());
        assertTrue(errorBuilder.getFieldErrors().containsKey("emailAddress"));

    }


    @Test
    void shouldNotReturnErrorWhenRegisteringEmployeeWithNotTakenEmail() {
        EmailAddress address = new EmailAddress("Test123@gmail.com");
        when(userQueryRepository.findByEmailAddress(address)).thenReturn(Optional.empty());
        createEmployeeCommandValidator.validateIfEmailIsAlreadyTaken(address, errorBuilder);
        assertFalse(errorBuilder.containsErrors());
        assertFalse(errorBuilder.getFieldErrors().containsKey("emailAddress"));
    }

    @Test
    void validatorShouldSupportCreateEmployerCommand() {
        assertTrue(createEmployeeCommandValidator.supportsCommand(CreateEmployeeCommand.class.getSimpleName()));
    }


}