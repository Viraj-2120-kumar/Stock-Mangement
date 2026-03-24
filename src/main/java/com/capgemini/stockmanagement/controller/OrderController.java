package com.capgemini.stockmanagement.controller;

import com.capgemini.stockmanagement.entity.Order;
import com.capgemini.stockmanagement.entity.OrderHistory;
import com.capgemini.stockmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/{id}/history")
    public ResponseEntity<List<OrderHistory>> getOrderHistory(@PathVariable Integer id) {
        List<OrderHistory> orderHistory = orderService.getOrderHistory(id);
        return ResponseEntity.ok(orderHistory);
    }
    
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody List<OrderService.CartItem> cartItems) {
        try {
            Order order = orderService.createOrder(cartItems);
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
