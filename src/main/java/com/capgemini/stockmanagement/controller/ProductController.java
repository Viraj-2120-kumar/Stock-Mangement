package com.capgemini.stockmanagement.controller;

import com.capgemini.stockmanagement.entity.Product;
import com.capgemini.stockmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String general) {
        
        List<Product> products;
        
        if (general != null && !general.trim().isEmpty()) {
            products = productService.searchProductsByAnyField(general);
        } else if (name != null && !name.trim().isEmpty()) {
            products = productService.searchProductsByName(name);
        } else if (category != null && !category.trim().isEmpty()) {
            products = productService.searchProductsByCategory(category);
        } else if (company != null && !company.trim().isEmpty()) {
            products = productService.searchProductsByCompany(company);
        } else {
            products = productService.getAllProducts();
        }
        
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/low-stock")
    public ResponseEntity<List<Product>> getLowStockProducts(
            @RequestParam(defaultValue = "10") Integer threshold) {
        List<Product> products = productService.getLowStockProducts(threshold);
        return ResponseEntity.ok(products);
    }
    
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer id,
            @Valid @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @PatchMapping("/{id}/stock")
    public ResponseEntity<Void> updateStock(
            @PathVariable Integer id,
            @RequestParam Integer quantityChange) {
        boolean updated = productService.updateStock(id, quantityChange);
        if (updated) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
