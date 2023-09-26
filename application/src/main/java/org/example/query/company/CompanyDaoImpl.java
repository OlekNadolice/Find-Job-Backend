package org.example.query.company;



import org.example.dto.company.CompanyDTO;
import org.example.exceptions.RecordNotFoundException;

import org.example.repositories.company.CompanyQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyDaoImpl implements  CompanyDao {

    private final CompanyQueryRepository companyQueryRepository;


    public CompanyDaoImpl(CompanyQueryRepository companyQueryRepository) {
        this.companyQueryRepository = companyQueryRepository;
    }

    public CompanyDTO getCompanyById(UUID companyId) {
        var company  = this.companyQueryRepository.findById(companyId);
        return null;
//        return company.map(CompanyMapper::ToCompanyDTO)
//                .orElseThrow(()
//                        -> new RecordNotFoundException
//                        ("Company with id " + companyId + " not found "));

    }



    public List<CompanyDTO> getAllCompanies() {
        var companies = this.companyQueryRepository.findAll();
        return null;
//        return companies.stream().map(CompanyMapper::ToCompanyDTO).toList();
    }
}
