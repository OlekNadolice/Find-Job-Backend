package org.example.query.company.getCompany;

import org.example.IRequestHandler;
import org.example.dto.company.CompanyDTO;
import org.example.exceptions.RecordNotFoundException;
import org.example.mapper.company.CompanyMapper;
import org.example.repositories.Company.CompanyQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCompanyQueryHandler implements IRequestHandler<GetCompanyQuery> {

    private final CompanyQueryRepository companyRepository;

    @Autowired
    public GetCompanyQueryHandler(CompanyQueryRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public CompanyDTO execute(GetCompanyQuery query) {
        var company  = this.companyRepository.findById(query.companyId());
        return company.map(CompanyMapper::ToCompanyDTO)
                .orElseThrow(()
                        -> new RecordNotFoundException
                        ("Company with id " + query.companyId() + " not found "));

    }


    @Override
    public boolean supportsOperation(Object query) {
        return GetCompanyQuery.class.equals(query);
    }
}
