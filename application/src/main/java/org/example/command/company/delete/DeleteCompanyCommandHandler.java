package org.example.command.company.delete;

import org.example.IRequestHandler;
import org.example.repositories.Company.CompanyCommandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCompanyCommandHandler implements IRequestHandler<DeleteCompanyCommand> {

    private final CompanyCommandRepository companyRepository;

    @Autowired
    public DeleteCompanyCommandHandler(CompanyCommandRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Object execute(DeleteCompanyCommand command) {
        this.companyRepository.deleteById(command.companyId());
        return  null;
    }


    @Override
    public boolean supportsOperation(Object command) {
        return DeleteCompanyCommand.class.equals(command);
    }
}
