package org.example.services;


import org.example.api.dto.CompanyDTO;
import org.example.api.dto.CreateCompanyDTO;
import org.example.api.mapper.CompanyMapper;
import org.example.exceptions.CompanyNotFoundException;
import org.example.model.CompanyRepository;
import org.example.services.validation.CompanyValidator;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final  CompanyValidator companyValidator;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyValidator companyValidator) {
        this.companyRepository = companyRepository;
        this.companyValidator = companyValidator;
    }



    public List<CompanyDTO> getAllCompanies() {
        var companies = this.companyRepository.findAll();
        return companies.stream().map(CompanyMapper::ToCompanyDTO).toList();

    }

    public CompanyDTO getCompanyById(Long companyId) {
      var company  = this.companyRepository.findById(companyId);
         return company.map(CompanyMapper::ToCompanyDTO)
               .orElseThrow(()
                       -> new CompanyNotFoundException
                       ("Company with id " + companyId + " not found "));

    }

    public CreateCompanyDTO createCompany(CreateCompanyDTO c) {
        this.companyValidator.checkIfCompanyNipNumberTaken(c.companyNipNumber());
        this.companyValidator.checkIfCompanyRegonNumberTaken(c.companyRegonNumber());
        var company = CompanyMapper.ToEntity(c);
        this.companyRepository.save(company);
        return c;
    }

    public void deleteCompanyById(Long companyId) {
       this.companyValidator.checkIfCompanyExists(companyId);
        this.companyRepository.deleteById(companyId);

    }
}
