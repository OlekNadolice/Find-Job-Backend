package org.example.repositories.Company;

import org.example.Entities.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCommandRepository extends JpaRepository<Company, Long> {
}
