package org.example.repositories.advertisement;

import org.example.entities.advertisement.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdvertisementQueryRepository extends JpaRepository<Advertisement, UUID> {
}
