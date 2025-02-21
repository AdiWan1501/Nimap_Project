package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService 
{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) 
    {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() 
    {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) 
    {
        return categoryRepository.findById(id);
    }

    @Transactional
    public Category createCategory(Category category) 
    {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(Integer id, Category categoryDetails) 
    {
        return categoryRepository.findById(id)
                .map(category -> 
                {
                    category.setCategoryname(categoryDetails.getCategoryname());
                    return categoryRepository.save(category);
                })
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + id));
    }

    @Transactional
    public void deleteCategory(Integer id) 
    {
    	if(!categoryRepository.existsById(id))
    	{
    		throw new EntityNotFoundException("Category not found with ID:" + id);
    	}
    	categoryRepository.deleteById(id);
    }
}