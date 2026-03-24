package com.capgemini.stockmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartItemDto {
    
    @NotNull(message = "Product ID is required")
    private Integer productId;
    
    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;
    
    private String productName;
    private Double productPrice;
    
    public CartItemDto() {}
    
    public CartItemDto(Integer productId, Integer quantity) {
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
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public Double getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
