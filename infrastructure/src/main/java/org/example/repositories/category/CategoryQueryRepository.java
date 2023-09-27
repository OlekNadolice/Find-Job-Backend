package org.example.repositories.category;

import org.example.entities.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryQueryRepository extends JpaRepository<Category, UUID> {
}
