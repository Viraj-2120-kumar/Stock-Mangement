package com.capgemini.stockmanagement.repository;

import com.capgemini.stockmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    List<Product> findByNameContainingIgnoreCase(String name);
    
    List<Product> findByCategoryContainingIgnoreCase(String category);
    
    List<Product> findByCompanyContainingIgnoreCase(String company);
    
    @Query("SELECT p FROM Product p WHERE " +
           "LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(p.category) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(p.company) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Product> findByAnyField(@Param("searchTerm") String searchTerm);
    
    @Query("SELECT p FROM Product p WHERE p.quantity < :threshold")
    List<Product> findLowStockProducts(@Param("threshold") Integer threshold);
}
