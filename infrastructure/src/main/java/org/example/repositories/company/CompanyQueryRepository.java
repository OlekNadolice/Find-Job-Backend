package org.example.repositories.company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.entities.company.Company;
import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyQueryRepository extends CrudRepository<Company, UUID> {

    List<Company> findAll();

//    Optional<Company> findByCompanyNipNumber(UUID companyNipNumber);
//
//    Optional<Company> findByCompanyRegonNumber(UUID companyRegonNumber);
}
