package com.example.budget.model;

import com.example.budget.model.enumeration.CategoryType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private CategoryType type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
}
