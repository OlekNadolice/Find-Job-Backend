package org.example.repositories.User;

import org.example.entities.user.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserQueryRepository extends JpaRepository<CustomUser, UUID> {

    Optional<CustomUser> findByEmailAddress(String emailAddress);
}
