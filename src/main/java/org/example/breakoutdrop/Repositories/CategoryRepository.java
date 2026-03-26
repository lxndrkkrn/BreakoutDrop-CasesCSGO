package org.example.breakoutdrop.Repositories;

import org.example.breakoutdrop.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
