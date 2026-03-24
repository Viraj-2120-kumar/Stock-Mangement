package com.capgemini.stockmanagement.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    
    private Integer orderId;
    private Double totalPrice;
    private Double totalPriceWithGst;
    private LocalDateTime orderDate;
    private List<OrderItemDto> items;
    
    public OrderResponseDto() {}
    
    public OrderResponseDto(Integer orderId, Double totalPrice, Double totalPriceWithGst, 
                           LocalDateTime orderDate, List<OrderItemDto> items) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.totalPriceWithGst = totalPriceWithGst;
        this.orderDate = orderDate;
        this.items = items;
    }
    
    public Integer getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
    
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    
    public List<OrderItemDto> getItems() {
        return items;
    }
    
    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
    
    public static class OrderItemDto {
        private Integer productId;
        private String productName;
        private String company;
        private Integer quantity;
        private Double priceAtOrder;
        
        public OrderItemDto() {}
        
        public OrderItemDto(Integer productId, String productName, String company, 
                           Integer quantity, Double priceAtOrder) {
            this.productId = productId;
            this.productName = productName;
            this.company = company;
            this.quantity = quantity;
            this.priceAtOrder = priceAtOrder;
        }
        
        public Integer getProductId() {
            return productId;
        }
        
        public void setProductId(Integer productId) {
            this.productId = productId;
        }
        
        public String getProductName() {
            return productName;
        }
        
        public void setProductName(String productName) {
            this.productName = productName;
        }
        
        public String getCompany() {
            return company;
        }
        
        public void setCompany(String company) {
            this.company = company;
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
}
