package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> 
{
    // Find category by name
    Optional<Category> findByCategoryname(String categoryname);
}