package org.example.command.company.create;

import org.example.entities.address.Address;
import org.example.entities.category.Category;
import org.example.entities.company.Company;
import org.example.exceptions.ErrorBuilder;
import org.example.repositories.company.CompanyQueryRepository;
import org.example.valueobjects.NipNumber;
import org.example.valueobjects.RegonNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CreateCompanyCommandValidatorTest {

    @Mock
    private CompanyQueryRepository companyQueryRepository;

    private  CreateCompanyCommandValidator createCompanyCommandValidator;

    private final  CreateCompanyCommand command = new CreateCompanyCommand(
            "TestCompany",
            null,
            Set.of(new Category()),
            "description",
            List.of(new Address()),
            new NipNumber("nipTest"),
            new RegonNumber("regonTest"),
            LocalDate.now()
            );

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        createCompanyCommandValidator = new CreateCompanyCommandValidator(companyQueryRepository);
    }

    @Test
    void shouldThrowErrorWhenNipNumberAlreadyExists() {
        ErrorBuilder errorBuilder = new ErrorBuilder();
        when(companyQueryRepository.findByCompanyNipNumber(new NipNumber("nipTest"))).thenReturn(Optional.of(new Company()));
        createCompanyCommandValidator.checkIfCompanyWithNipNumberAlreadyExists(command, errorBuilder);
        assertTrue(errorBuilder.containsErrors());
        assertTrue(errorBuilder.getFieldErrors().containsKey("companyNipNumber"));
    }


    @Test
    void shouldThrowErrorWhenRegonNumberAlreadyExists() {
        ErrorBuilder errorBuilder = new ErrorBuilder();
        when(companyQueryRepository.findByCompanyRegonNumber(new RegonNumber("regonTest"))).thenReturn(Optional.of(new Company()));
        createCompanyCommandValidator.checkIfCompanyWithRegonNumberAlreadyExists(command, errorBuilder);
        assertTrue(errorBuilder.containsErrors());
        assertTrue(errorBuilder.getFieldErrors().containsKey("companyRegonNumber"));
    }


    @Test
    void shouldNotThrowErrorWhenNipNumberDoesntExists() {
        ErrorBuilder errorBuilder = new ErrorBuilder();
        when(companyQueryRepository.findByCompanyNipNumber(new NipNumber("nipTest"))).thenReturn(Optional.empty());
        createCompanyCommandValidator.checkIfCompanyWithNipNumberAlreadyExists(command, errorBuilder);
        assertFalse(errorBuilder.containsErrors());
        assertFalse(errorBuilder.getFieldErrors().containsKey("companyNipNumber"));
    }


    @Test
    void shouldNotThrowErrorWhenRegonNumberDoesntExists() {
        ErrorBuilder errorBuilder = new ErrorBuilder();
        when(companyQueryRepository.findByCompanyRegonNumber(new RegonNumber("nipTest"))).thenReturn(Optional.empty());
        createCompanyCommandValidator.checkIfCompanyWithRegonNumberAlreadyExists(command, errorBuilder);
        assertFalse(errorBuilder.containsErrors());
        assertFalse(errorBuilder.getFieldErrors().containsKey("companyRegonNumber"));
    }

    @Test
    void validatorShouldSupportCreateCompanyCommand() {
        createCompanyCommandValidator.supportsCommand(CreateCompanyCommand.class.getSimpleName());
    }

}