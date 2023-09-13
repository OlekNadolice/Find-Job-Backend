package org.example.query.company;

import org.example.dto.company.CompanyDTO;

import java.util.List;
import java.util.UUID;

public interface CompanyDao {

    CompanyDTO getCompanyById(UUID companyId);

    List<CompanyDTO> getAllCompanies();
}
