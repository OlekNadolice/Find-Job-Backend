package org.example.repositories.benefit;

import org.example.entities.benefit.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BenefitCommandRepository  extends JpaRepository<Benefit, UUID> {
}
