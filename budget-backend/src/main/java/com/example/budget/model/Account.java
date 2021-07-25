package com.example.budget.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double currentBalance;

    @ManyToOne
    @JoinColumn(name="currency_id",nullable = false)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;




}
