package org.example.repositories.employer;

import org.example.entities.employer.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployerQueryRepository extends JpaRepository<Employer, UUID> {

//    @Query("@Query(\"SELECT e FROM Employer e INNER JOIN e.customUser c WHERE c.emailAddress = :emailAddress\")")
    Employer getByEmailAddress(String emailAddress);



}
