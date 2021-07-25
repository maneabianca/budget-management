package com.example.budget.service;

import com.example.budget.dto.CategoryDto;
import com.example.budget.model.Category;
import com.example.budget.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }

    public void createCategory(CategoryDto newCategory){
        Category category = new Category();
        category.setId(newCategory.getId());
        category.setName(newCategory.getName());
        categoryRepository.saveAndFlush(category);
    }

    public void updateCategory(Long id, CategoryDto categoryDto) {
    }

    public void deleteCategory(Long id) {
    }

    public void getCategoryListByType(Long id, String type) {
    }
}
