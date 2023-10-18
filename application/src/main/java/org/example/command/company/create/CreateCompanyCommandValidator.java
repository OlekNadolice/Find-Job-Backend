package org.example.command.company.create;

import org.example.ICommandValidator;
import org.example.exceptions.ErrorBuilder;
import org.example.repositories.company.CompanyQueryRepository;
import org.springframework.stereotype.Service;



@Service
public class CreateCompanyCommandValidator implements ICommandValidator<CreateCompanyCommand> {

    private  final CompanyQueryRepository companyQueryRepository;

    public CreateCompanyCommandValidator(CompanyQueryRepository companyQueryRepository) {
        this.companyQueryRepository = companyQueryRepository;
    }

    @Override
    public void validate(CreateCompanyCommand command, ErrorBuilder errorBuilder) {
        checkIfCompanyWithNipNumberAlreadyExists(command, errorBuilder);
        checkIfCompanyWithRegonNumberAlreadyExists(command, errorBuilder);
    }

    @Override
    public boolean supportsCommand(Object command) {
        return CreateCompanyCommand.class.getSimpleName().equals(command);
    }


    public void checkIfCompanyWithNipNumberAlreadyExists(CreateCompanyCommand command , ErrorBuilder errorBuilder) {
        var company = this.companyQueryRepository.findByCompanyNipNumber(command.getCompanyNipNumber());

        if(company.isPresent()) {
            errorBuilder.addErrorField("companyNipNumber", "Nip number is already taken");
        }

    }

    public void checkIfCompanyWithRegonNumberAlreadyExists(CreateCompanyCommand command , ErrorBuilder errorBuilder) {
        var company = this.companyQueryRepository.findByCompanyRegonNumber(command.getCompanyRegonNumber());

        if(company.isPresent()) {
            errorBuilder.addErrorField("companyRegonNumber", "Regon number is already taken");
        }
    }



}
