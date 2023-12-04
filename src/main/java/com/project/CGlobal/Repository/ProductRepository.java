package com.project.CGlobal.Repository;

import com.project.CGlobal.Domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName(String name);
    List<Product> findProductByCategory(String category);
    Product findProductById(Long id);
    @Query("SELECT p FROM Product p WHERE " +
            "(:categoryId IS NULL OR p.category.id = :categoryId) AND " +
            "(:price IS NULL OR p.price = :price) AND " +
            "(:brand IS NULL OR p.brand = :brand) AND " +
            "(:color IS NULL OR p.color = :color) AND " +
            "(:name IS NULL OR p.name = :name)")
    Page<Product> findAllByFilters(Long categoryId, BigDecimal price, String brand, String color, String name, Pageable pageable);
}
