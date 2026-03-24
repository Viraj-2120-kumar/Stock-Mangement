package com.capgemini.stockmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductDto {
    
    private Integer id;
    
    @NotBlank(message = "Product name is required")
    private String name;
    
    @NotBlank(message = "Category is required")
    private String category;
    
    @NotBlank(message = "Company is required")
    private String company;
    
    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity cannot be negative")
    private Integer quantity;
    
    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price cannot be negative")
    private Double price;
    
    public ProductDto() {}
    
    public ProductDto(String name, String category, String company, Integer quantity, Double price) {
        this.name = name;
        this.category = category;
        this.company = company;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
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
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
}
