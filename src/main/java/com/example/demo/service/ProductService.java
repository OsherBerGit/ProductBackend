package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // create new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Optional<Product> updateProduct(Long id, Product productDetails) {
        Optional<Product> product =  getProductById(id);
        if (product.isPresent()) {
            productRepository.save(productDetails);
            return productRepository.findById(id);
        }
        return product;
    }

    public void deleteProduct(Long id) {
        if (getProductById(id).isPresent())
            productRepository.deleteById(id);
    }

    public List<Product> findByNameContaining (String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Product> findByPriceLessThan(Double price){
        return productRepository.findByPriceLessThan(price);
    }
}
