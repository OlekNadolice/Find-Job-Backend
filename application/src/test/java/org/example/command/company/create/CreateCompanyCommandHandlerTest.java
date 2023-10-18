package org.example.command.company.create;

import org.example.entities.address.Address;
import org.example.entities.category.Category;
import org.example.entities.employer.Employer;
import org.example.repositories.company.CompanyCommandRepository;
import org.example.repositories.employer.EmployerQueryRepository;
import org.example.security.config.SecurityConfig;
import org.example.valueobjects.NipNumber;
import org.example.valueobjects.RegonNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateCompanyCommandHandlerTest {


    @Mock
    private CompanyCommandRepository companyCommandRepository;

    @Mock
    private EmployerQueryRepository employerQueryRepository;

    @Mock
    private  SecurityConfig securityConfig;





    @InjectMocks
    private CreateCompanyCommandHandler createCompanyCommandHandler;

    private final CreateCompanyCommand command = new CreateCompanyCommand(
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
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void shouldCreateCompanyAsEmployer() {
        Employer mockedEmployer = new Employer();
        String testMail = "test123@wp.pl";
        when(securityConfig.getCurrentUser()).thenReturn(testMail);
        when(employerQueryRepository.getByEmailAddress(testMail)).thenReturn(mockedEmployer);
        createCompanyCommandHandler.execute(command);

        verify(companyCommandRepository,  times(1))
                .save(createCompanyCommandHandler.mapToCompany(command));




    }

}