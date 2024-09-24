package com.example.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.example.model.Product;
import com.example.repo.ProductRepo;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	// Save the product to the database
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
    
 

    // Get all products with pagination
    public Page<Product> getAllProductsPaginated(int page, int size) {
        return productRepo.findAll(PageRequest.of(page, size));
    }

    // Get all products without pagination (if needed)
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
