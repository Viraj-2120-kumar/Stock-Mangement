package com.capgemini.stockmanagement.repository;

import com.capgemini.stockmanagement.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
    
    List<OrderHistory> findByOrderId(Integer orderId);
    
    List<OrderHistory> findByProductId(Integer productId);
    
    @Query("SELECT oh FROM OrderHistory oh WHERE oh.order.id = :orderId")
    List<OrderHistory> findOrderDetailsByOrderId(@Param("orderId") Integer orderId);
}
