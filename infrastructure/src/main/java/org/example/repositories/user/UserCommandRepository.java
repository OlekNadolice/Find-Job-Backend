package org.example.repositories.user;


import org.example.entities.user.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCommandRepository extends JpaRepository<CustomUser, UUID> {
}
