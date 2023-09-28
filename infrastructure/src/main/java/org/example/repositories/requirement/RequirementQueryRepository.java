package org.example.repositories.requirement;

import org.example.entities.requirement.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequirementQueryRepository extends JpaRepository<Requirement, UUID> {
}
