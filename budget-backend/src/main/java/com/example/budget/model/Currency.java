package com.example.budget.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private double value;
}
