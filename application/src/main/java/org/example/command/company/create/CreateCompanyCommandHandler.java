package org.example.command.company.create;

import org.example.Entities.Company.Company;
import org.example.IRequestHandler;
import org.example.repositories.Company.CompanyCommandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyCommandHandler implements IRequestHandler<CreateCompanyCommand> {

    private final CompanyCommandRepository companyRepository;


    @Autowired
    public CreateCompanyCommandHandler(CompanyCommandRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public Object execute(CreateCompanyCommand command) {
       var c =  mapToCompany(command);
       this.companyRepository.save(c);
        return null;
    }

    public Company mapToCompany(CreateCompanyCommand command) {
        var company = new Company();
        company.setCompanyAddress(command.companyAddress());
        company.setCompanyCategory(command.companyCategories());
        company.setCompanyCreationDate(command.companyCreationDate());
        company.setCompanyImage(command.companyImage());
        company.setCompanyName(command.companyName());
        company.setCompanyDescription(command.companyDescription());
        company.setCompanyNipNumber(command.companyNipNumber());
        company.setCompanyRegonNumber(command.companyRegonNumber());
        return company;
    }


    @Override
    public boolean supportsOperation(Object command) {
        return CreateCompanyCommand.class.equals(command);
    }
}
