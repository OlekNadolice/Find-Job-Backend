package org.example.repositories.Company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.Entities.Company.Company;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyQueryRepository extends CrudRepository<Company, Long> {

    List<Company> findAll();

    Optional<Company> findByCompanyNipNumber(Long companyNipNumber);

    Optional<Company> findByCompanyRegonNumber(Long companyRegonNumber);
}
