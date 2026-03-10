package com.example.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Insert sample products
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Find by category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Filter by price range
    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min,
                                     @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sorted by price
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repo.getProductsSortedByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {
        return repo.getExpensiveProducts(price);
    }
}