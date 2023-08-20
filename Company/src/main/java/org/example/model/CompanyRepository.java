package org.example.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findAll();

    Optional<Company> findByCompanyNipNumber(Long companyNipNumber);

    Optional<Company> findByCompanyRegonNumber(Long companyRegonNumber);
}
