package com.example.budget.service;

import com.example.budget.dto.CategoryDto;
import com.example.budget.helper.CategoryDtoHelper;
import com.example.budget.model.Category;
import com.example.budget.model.enumeration.CategoryType;
import com.example.budget.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryDtoHelper categoryDtoHelper;

    public List<CategoryDto> getCategoryList(){
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for(Category category: categoryList){
            categoryDtoList.add(categoryDtoHelper.convertToDto(category));
        }
        return categoryDtoList;
    }

    public void createCategory(CategoryDto newCategory){
        Category category = categoryDtoHelper.convertToEntity(newCategory);
        categoryRepository.saveAndFlush(category);
    }

    public void updateCategory(Long id, CategoryDto categoryDto) throws Exception {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()){
            throw new
                    Exception("The category with "+id+" does'nt exist.");
        }
        category.get().setName(categoryDto.getName());
        category.get().setType(CategoryType.valueOf(categoryDto.getType()));

        categoryRepository.saveAndFlush(category.get());

    }

    public void deleteCategory(Long id) throws Exception {
        if(!categoryRepository.existsById(id)){
            throw new Exception("The category with "+ id +" doesn't exist.");
        }
        categoryRepository.deleteById(id);

    }

    public List<CategoryDto> getCategoryListByType(Long id, String type) {

        List<Category> categoryList = categoryRepository.findAllByUserAndType(id, CategoryType.valueOf(type).ordinal());
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtoList.add(categoryDtoHelper.convertToDto(category));
        }
        return categoryDtoList;
    }
}
