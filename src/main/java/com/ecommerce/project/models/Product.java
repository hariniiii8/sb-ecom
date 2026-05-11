package com.ecommerce.project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String description;
    private String image;
    private String productName;
    private Integer quantity;
    private double price;
    private double specialPrice;
    private double discount;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
