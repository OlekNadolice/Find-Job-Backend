package org.example.repositories.role;

import org.example.entities.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleCommandRepository extends JpaRepository<Role , UUID> {
}
