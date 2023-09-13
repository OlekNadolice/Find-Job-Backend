package org.example.repositories.Company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.Entities.Company.Company;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyQueryRepository extends CrudRepository<Company, UUID> {

    List<Company> findAll();

//    Optional<Company> findByCompanyNipNumber(UUID companyNipNumber);
//
//    Optional<Company> findByCompanyRegonNumber(UUID companyRegonNumber);
}
