package com.example.demo.Repository;

import com.example.demo.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> 
{
    // Find product by name
    Optional<Products> findByProductname(String productname);
}