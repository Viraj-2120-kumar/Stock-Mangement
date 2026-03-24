package com.capgemini.stockmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Order_History_Info")
public class OrderHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Order ID is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @NotNull(message = "Product ID is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @NotNull(message = "Quantity is required")
    @Column(nullable = false)
    private Integer quantity;
    
    @NotNull(message = "Price at time of order is required")
    @Column(nullable = false)
    private Double priceAtOrder;
    
    public OrderHistory() {}
    
    public OrderHistory(Order order, Product product, Integer quantity, Double priceAtOrder) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.priceAtOrder = priceAtOrder;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getPriceAtOrder() {
        return priceAtOrder;
    }
    
    public void setPriceAtOrder(Double priceAtOrder) {
        this.priceAtOrder = priceAtOrder;
    }
}
