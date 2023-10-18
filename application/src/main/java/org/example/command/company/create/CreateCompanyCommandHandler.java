package org.example.command.company.create;

import org.example.entities.company.Company;
import org.example.IRequestHandler;
import org.example.entities.employer.Employer;
import org.example.repositories.company.CompanyCommandRepository;


import org.example.repositories.employer.EmployerQueryRepository;
import org.example.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Optional;

@Component
public class CreateCompanyCommandHandler implements IRequestHandler<CreateCompanyCommand> {

    private final CompanyCommandRepository companyRepository;

    private final EmployerQueryRepository employerQueryRepository;

    private  final  SecurityConfig securityConfig;




    public CreateCompanyCommandHandler(CompanyCommandRepository companyRepository, EmployerQueryRepository employerQueryRepository, SecurityConfig securityConfig) {
        this.companyRepository = companyRepository;
        this.employerQueryRepository = employerQueryRepository;
        this.securityConfig = securityConfig;
    }

    @Override
    public void execute(CreateCompanyCommand command) {
        var c = mapToCompany(command);
        this.companyRepository.save(c);

    }

    public Company mapToCompany(CreateCompanyCommand command) {
        Employer employer = this.employerQueryRepository.getByEmailAddress(securityConfig.getCurrentUser());
        var company = new Company();
        company.setEmployer(employer);
        company.setAddress(command.getCompanyAddress());
        company.setCompanyCategory(command.getCompanyCategories());
        company.setCreationDate(command.getCompanyCreationDate());
        company.setCompanyImage(command.getCompanyImage());
        company.setCompanyName(command.getCompanyName());
        company.setCompanyDescription(command.getCompanyDescription());
        company.setCompanyNipNumber(command.getCompanyNipNumber());
        company.setCompanyRegonNumber(command.getCompanyRegonNumber());
        return company;
    }


    @Override
    public boolean supportsOperation(Object command) {
        return CreateCompanyCommand.class.getSimpleName().equals(command);
    }
}
