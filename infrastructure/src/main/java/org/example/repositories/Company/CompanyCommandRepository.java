package org.example.repositories.Company;

import org.example.entities.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyCommandRepository extends JpaRepository<Company, UUID> {
}
