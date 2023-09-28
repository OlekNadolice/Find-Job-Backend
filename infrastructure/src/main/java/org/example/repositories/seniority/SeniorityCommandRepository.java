package org.example.repositories.seniority;

import org.example.entities.seniority.Seniority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SeniorityCommandRepository extends JpaRepository<Seniority, UUID> {
}
