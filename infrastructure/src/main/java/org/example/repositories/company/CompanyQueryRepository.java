package org.example.repositories.company;

import org.example.valueobjects.NipNumber;
import org.example.valueobjects.RegonNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.entities.company.Company;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyQueryRepository extends CrudRepository<Company, UUID> {

    List<Company> findAll();

   Optional<Company> findByCompanyNipNumber(NipNumber companyNipNumber);

    Optional<Company> findByCompanyRegonNumber(RegonNumber companyRegonNumber);
}
