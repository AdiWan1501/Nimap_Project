package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Products;
import com.example.demo.Repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService 
{
	@Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) 
    {
        this.productRepository = productRepository;
    }

    public List<Products> getAllProducts() 
    {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(Integer id) 
    {
        return productRepository.findById(id);
    }

    public Products createProduct(Products product) 
    {
        return productRepository.save(product);
    }

    public Products updateProduct(Integer id, Products productDetails) 
    {
        return productRepository.findById(id)
                .map(product -> {
                    product.setProductname(productDetails.getProductname());
                    product.setCategory(productDetails.getCategory());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Integer id) 
    {
        productRepository.deleteById(id);
    }
}
