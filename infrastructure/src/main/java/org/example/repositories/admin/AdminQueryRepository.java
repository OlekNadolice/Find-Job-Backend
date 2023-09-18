package org.example.repositories.admin;

import org.example.entities.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminQueryRepository extends JpaRepository<Admin, UUID> {
}
