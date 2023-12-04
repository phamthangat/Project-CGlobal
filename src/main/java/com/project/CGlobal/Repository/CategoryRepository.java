package com.project.CGlobal.Repository;

import com.project.CGlobal.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryById(Long id);
}
