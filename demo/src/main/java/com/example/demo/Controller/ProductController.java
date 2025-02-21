package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Products;
import com.example.demo.Service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
    private final ProductService productService;

    public ProductController(ProductService productService) 
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getAllProducts() 
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable Integer id) 
    {
        Optional<Products> product = productService.getProductById(id);
        if (product.isEmpty()) 
        {
            throw new RuntimeException("Product not found, id: " + id);
        }
        return product;
    }

    @PostMapping("/add")
    public Products createProduct(@RequestBody Products product) 
    {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Integer id, @RequestBody Products product) 
    {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id)
    {
    	productService.deleteProduct(id);
    }
}