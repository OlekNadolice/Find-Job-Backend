package org.example.repositories.applicant;

import org.example.entities.applicant.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicantQueryRepository extends JpaRepository<Applicant, UUID> {
}
