package com.example.budget.controller;

import com.example.budget.dto.CategoryDto;
import com.example.budget.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<?> getCategoryList() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryList());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto newCategory) {

        categoryService.createCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        try {
            categoryService.updateCategory(id, categoryDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // ?type=INCOME
    //id de la user
    @GetMapping("/{id}/list")
    public ResponseEntity<?> getCategoryListByType(@PathVariable Long id, @RequestParam String type) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryListByType(id, type));
    }
}
