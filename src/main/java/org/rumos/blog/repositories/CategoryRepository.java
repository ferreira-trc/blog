package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long>{

    public Category findByCategory(String category);
}
