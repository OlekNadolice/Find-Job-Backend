package org.example.query.company;

import org.example.dto.company.CompanyDTO;

import java.util.List;

public interface CompanyDao {

    CompanyDTO getCompanyById(Long companyId);

    List<CompanyDTO> getAllCompanies();
}
