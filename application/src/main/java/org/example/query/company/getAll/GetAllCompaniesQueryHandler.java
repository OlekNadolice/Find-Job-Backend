package org.example.query.company.getAll;

import org.example.IRequestHandler;
import org.example.dto.company.CompanyDTO;
import org.example.mapper.company.CompanyMapper;
import org.example.repositories.Company.CompanyQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCompaniesQueryHandler implements IRequestHandler<GetAllCompaniesQuery> {

    private final CompanyQueryRepository companyRepository;

    @Autowired
    public GetAllCompaniesQueryHandler(CompanyQueryRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<CompanyDTO> execute(GetAllCompaniesQuery query) {
        var companies = this.companyRepository.findAll();
        return companies.stream().map(CompanyMapper::ToCompanyDTO).toList();
    }

    @Override
    public boolean supportsOperation(Object query) {
        return GetAllCompaniesQuery.class.equals(query);
    }
}
