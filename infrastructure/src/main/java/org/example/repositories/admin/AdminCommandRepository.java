package org.example.repositories.admin;

import org.example.entities.admin.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminCommandRepository extends CrudRepository<Admin, UUID> {
}
