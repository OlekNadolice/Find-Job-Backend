package org.example.repositories.address;


import org.example.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressQueryRepository extends JpaRepository<Address, UUID> {
}
