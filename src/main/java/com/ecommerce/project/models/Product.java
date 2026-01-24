package com.ecommerce.project.models;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String description;
    private String productName;
    private Integer quantity;
    private double price;
    private double specialPrice;
    private double discount;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
