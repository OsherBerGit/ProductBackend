package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // post mapping new product
    @PostMapping("/newproduct")
    public Product newProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Optional<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/namecontainingproducts/{name}")
    public List<Product> getNameContainingProducts(@PathVariable String name) {
        return productService.findByNameContaining(name);
    }

    @GetMapping("/lesspricedproducts/{price}")
    public List<Product> getLessPricedProducts(@PathVariable Double price) {
        return productService.findByPriceLessThan(price);
    }
}
