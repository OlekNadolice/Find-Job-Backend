package org.example.repositories.employer;

import org.example.entities.employer.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployerCommandRepository extends JpaRepository<Employer, UUID> {
}
