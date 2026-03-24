package com.capgemini.stockmanagement.service;

import com.capgemini.stockmanagement.entity.Order;
import com.capgemini.stockmanagement.entity.OrderHistory;
import com.capgemini.stockmanagement.entity.Product;
import com.capgemini.stockmanagement.repository.OrderRepository;
import com.capgemini.stockmanagement.repository.OrderHistoryRepository;
import com.capgemini.stockmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    private static final double GST_RATE = 0.18;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Order> getAllOrders() {
        return orderRepository.findByOrderByCreatedAtDesc();
    }
    
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }
    
    @Transactional
    public Order createOrder(List<CartItem> cartItems) {
        double totalPrice = 0.0;
        
        for (CartItem item : cartItems) {
            Optional<Product> product = productRepository.findById(item.getProductId());
            if (product.isPresent()) {
                Product p = product.get();
                if (p.getQuantity() >= item.getQuantity()) {
                    totalPrice += p.getPrice() * item.getQuantity();
                } else {
                    throw new RuntimeException("Insufficient stock for product: " + p.getName());
                }
            } else {
                throw new RuntimeException("Product not found with ID: " + item.getProductId());
            }
        }
        
        double totalPriceWithGst = totalPrice * (1 + GST_RATE);
        
        Order order = new Order(totalPrice, totalPriceWithGst);
        Order savedOrder = orderRepository.save(order);
        
        for (CartItem item : cartItems) {
            Optional<Product> product = productRepository.findById(item.getProductId());
            if (product.isPresent()) {
                Product p = product.get();
                
                p.setQuantity(p.getQuantity() - item.getQuantity());
                productRepository.save(p);
                
                OrderHistory orderHistory = new OrderHistory(savedOrder, p, item.getQuantity(), p.getPrice());
                orderHistoryRepository.save(orderHistory);
            }
        }
        
        return savedOrder;
    }
    
    public List<OrderHistory> getOrderHistory(Integer orderId) {
        return orderHistoryRepository.findOrderDetailsByOrderId(orderId);
    }
    
    public static class CartItem {
        private Integer productId;
        private Integer quantity;
        
        public CartItem() {}
        
        public CartItem(Integer productId, Integer quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }
        
        public Integer getProductId() {
            return productId;
        }
        
        public void setProductId(Integer productId) {
            this.productId = productId;
        }
        
        public Integer getQuantity() {
            return quantity;
        }
        
        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
