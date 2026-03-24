package com.capgemini.stockmanagement.repository;

import com.capgemini.stockmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    List<Order> findByOrderByCreatedAtDesc();
}
