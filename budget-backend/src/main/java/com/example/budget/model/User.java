package com.example.budget.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

//    @OneToMany
//    private Set<Category> categorySet;


}
