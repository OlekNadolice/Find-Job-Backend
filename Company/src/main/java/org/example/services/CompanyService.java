package org.example.services;

import org.example.api.dto.CompanyDTO;
import org.example.api.dto.CreateCompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> getAllCompanies();

    CompanyDTO getCompanyById(Long companyId);

    CreateCompanyDTO createCompany(CreateCompanyDTO company);

    void deleteCompanyById(Long companyId);
}
