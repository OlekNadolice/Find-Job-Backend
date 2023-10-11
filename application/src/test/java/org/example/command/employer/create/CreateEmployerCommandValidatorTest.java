package org.example.command.employer.create;


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
import static org.mockito.Mockito.*;

class CreateEmployerCommandValidatorTest {

    @Mock
    private UserQueryRepository userQueryRepository;

    private CreateEmployerCommandValidator createEmployerCommandValidator;


    private  ErrorBuilder errorBuilder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        createEmployerCommandValidator = new CreateEmployerCommandValidator(userQueryRepository);
        errorBuilder = new ErrorBuilder();

    }

    @Test
    void shouldReturnErrorWhenRegisteringEmployerWithAlreadyTakenEmail() {
        CustomUser customUser = new CustomUser();
        EmailAddress address = new EmailAddress("Test123@gmail.com");
        when(userQueryRepository.findByEmailAddress(address)).thenReturn(Optional.of(customUser));
        createEmployerCommandValidator.validateIfEmailIsAlreadyTaken(address, errorBuilder);
        assertTrue(errorBuilder.containsErrors());
        assertTrue(errorBuilder.getFieldErrors().containsKey("emailAddress"));

    }


    @Test
    void shouldNotReturnErrorWhenRegisteringEmployerWithNotTakenEmail() {
        EmailAddress address = new EmailAddress("Test123@gmail.com");
        when(userQueryRepository.findByEmailAddress(address)).thenReturn(Optional.empty());
        createEmployerCommandValidator.validateIfEmailIsAlreadyTaken(address, errorBuilder);
        assertFalse(errorBuilder.containsErrors());
        assertFalse(errorBuilder.getFieldErrors().containsKey("emailAddress"));
    }


    @Test
    void validatorShouldSupportCreateEmployerCommand() {
        assertTrue(createEmployerCommandValidator.supportsCommand(CreateEmployerCommand.class.getSimpleName()));
    }

}