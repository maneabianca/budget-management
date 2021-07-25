package com.example.budget.helper;

import com.example.budget.dto.CategoryDto;
import com.example.budget.model.Category;
import com.example.budget.model.enumeration.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoHelper {

    @Autowired
    private UserDtoHelper userDtoHelper;

    public CategoryDto convertToDto(Category category){

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setType(category.getType().toString());
        categoryDto.setUserDto(userDtoHelper.convertToDto(category.getUser()));


        return categoryDto;
    }

    public Category convertToEntity(CategoryDto categoryDto){

        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setType(CategoryType.valueOf(categoryDto.getType()));
        category.setUser(userDtoHelper.convertToEntity(categoryDto.getUserDto()));

        return category;
    }


}
