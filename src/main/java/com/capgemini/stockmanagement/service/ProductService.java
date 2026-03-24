package com.capgemini.stockmanagement.service;

import com.capgemini.stockmanagement.entity.Product;
import com.capgemini.stockmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }
    
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<Product> searchProductsByCategory(String category) {
        return productRepository.findByCategoryContainingIgnoreCase(category);
    }
    
    public List<Product> searchProductsByCompany(String company) {
        return productRepository.findByCompanyContainingIgnoreCase(company);
    }
    
    public List<Product> searchProductsByAnyField(String searchTerm) {
        return productRepository.findByAnyField(searchTerm);
    }
    
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(Integer id, Product productDetails) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(productDetails.getName());
            product.setCategory(productDetails.getCategory());
            product.setCompany(productDetails.getCompany());
            product.setQuantity(productDetails.getQuantity());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        }
        return null;
    }
    
    public boolean deleteProduct(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Product> getLowStockProducts(Integer threshold) {
        return productRepository.findLowStockProducts(threshold);
    }
    
    public boolean updateStock(Integer productId, Integer quantityChange) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Product p = product.get();
            int newQuantity = p.getQuantity() + quantityChange;
            if (newQuantity >= 0) {
                p.setQuantity(newQuantity);
                productRepository.save(p);
                return true;
            }
        }
        return false;
    }
}
