package org.example.repositories.employment;

import org.example.entities.employment.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmploymentCommandRepository extends JpaRepository<Employment, UUID> {
}
