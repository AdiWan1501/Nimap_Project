package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController 
{
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) 
    {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() 
    {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Integer id) 
    {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isEmpty()) 
        {
            throw new RuntimeException("Category not found, id: " + id);
        }
        return category;
    }

    @PostMapping("/add")
    public Category createCategory(@RequestBody Category category) 
    {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) 
    {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) 
    {
    	categoryService.deleteCategory(id);
    }
}
