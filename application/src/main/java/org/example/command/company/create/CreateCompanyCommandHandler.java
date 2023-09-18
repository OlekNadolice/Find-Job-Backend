package org.example.command.company.create;

import org.example.entities.company.Company;
import org.example.IRequestHandler;
import org.example.repositories.company.CompanyCommandRepository;

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
    public void execute(CreateCompanyCommand command) {
       var c =  mapToCompany(command);
       this.companyRepository.save(c);

    }

    public Company mapToCompany(CreateCompanyCommand command) {
        var company = new Company();
        company.setCompanyAddress(command.getCompanyAddress());
        company.setCompanyCategory(command.getCompanyCategories());
        company.setCompanyCreationDate(command.getCompanyCreationDate());
        company.setCompanyImage(command.getCompanyImage());
        company.setCompanyName(command.getCompanyName());
        company.setCompanyDescription(command.getCompanyDescription());
        company.setCompanyNipNumber(command.getCompanyNipNumber());
        company.setCompanyRegonNumber(command.getCompanyRegonNumber());
        company.setId(command.getId());
        return company;
    }


    @Override
    public boolean supportsOperation(Object command) {
        return CreateCompanyCommand.class.equals(command);
    }
}
