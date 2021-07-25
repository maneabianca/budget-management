package com.example.budget.repository;

import com.example.budget.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    @Query(value = "SELECT * FROM categories WHERE user_id= ?1 and type= ?2", nativeQuery = true)
    List<Category> findAllByUserAndType(Long id, int type);
}
