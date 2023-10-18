package org.example.integration;


import org.example.command.company.create.CreateCompanyCommand;
import org.example.entities.address.Address;
import org.example.entities.category.Category;
import org.example.entities.employer.Employer;
import org.example.entities.role.Role;
import org.example.entities.user.CustomUser;
import org.example.enums.RoleType;
import org.example.mediator.Mediator;
import org.example.repositories.company.CompanyCommandRepository;
import org.example.repositories.company.CompanyQueryRepository;
import org.example.repositories.employer.EmployerCommandRepository;
import org.example.repositories.role.RoleCommandRepository;
import org.example.valueobjects.EmailAddress;
import org.example.valueobjects.NipNumber;
import org.example.valueobjects.Password;

import org.example.valueobjects.RegonNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import org.springframework.context.annotation.Profile;



import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = BaseIntegrationTest.class)
@EnableAutoConfiguration
@Profile("test")
@ComponentScan(basePackages = {"org.example.mediator", "org.example.validator"})
public class BaseIntegrationTest  extends  TestContainer {

    @Autowired
    protected Mediator mediator;
    @Autowired
    protected EmployerCommandRepository employerCommandRepository;





    @Autowired
    protected RoleCommandRepository roleCommandRepository;

    @Autowired
    protected CompanyCommandRepository companyCommandRepository;

    @Autowired
    protected CompanyQueryRepository companyQueryRepository;







    protected Employer createEmployer(String emailAddress, String password, String firstName, String lastName) {
        CustomUser customUser = new CustomUser();
        customUser.setPassword(new Password(password));
        customUser.setEmailAddress(new EmailAddress(emailAddress));
        customUser.setFirstName(firstName);
        customUser.setLastName(lastName);
        customUser.setRoles(Set.of(createRole(RoleType.EMPLOYER)));
        Employer employer = new Employer();
        employer.setUser(customUser);
        return  employerCommandRepository.save(employer);
    }


    protected  Role createRole(RoleType name) {
        Role role = new Role();
        role.setName(name);
        return roleCommandRepository.save(role);
    }


    @Test
    public  void shouldCreateCompany() {
        Employer employer = createEmployer("test123@wp.pl",
                "Password123456!",
                "Tester",
                "tester");

        CreateCompanyCommand command = new CreateCompanyCommand(
                "TestCompany",
                null,
                Set.of(new Category()),
                "description",
                List.of(new Address()),
                new NipNumber("nipTest"),
                new RegonNumber("regonTest"),
                LocalDate.now()
        );

        mediator.processRequest(command);

        Assertions.assertTrue(companyQueryRepository.findByCompanyNipNumber(command.getCompanyNipNumber()).isPresent());


    }


}