package com.capgemini.stockmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "Order_Info")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Total price is required")
    @PositiveOrZero(message = "Total price cannot be negative")
    @Column(nullable = false)
    private Double totalPrice;
    
    @NotNull(message = "Total price with GST is required")
    @PositiveOrZero(message = "Total price with GST cannot be negative")
    @Column(nullable = false)
    private Double totalPriceWithGst;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    public Order() {}
    
    public Order(Double totalPrice, Double totalPriceWithGst) {
        this.totalPrice = totalPrice;
        this.totalPriceWithGst = totalPriceWithGst;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public Double getTotalPriceWithGst() {
        return totalPriceWithGst;
    }
    
    public void setTotalPriceWithGst(Double totalPriceWithGst) {
        this.totalPriceWithGst = totalPriceWithGst;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
