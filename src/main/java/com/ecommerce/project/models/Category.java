package com.ecommerce.project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_seq")
//    @SequenceGenerator(name = "order_seq",sequenceName = "order_sequence",allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE,generator = "task_gen")
//    @TableGenerator(name = "task_gen", table = "id_gen",pkColumnName = "gen_key",valueColumnName = "gen_value",pkColumnValue = "task_id",allocationSize = 1)
    private Long categoryId;
    @NotBlank
    @Size(min=5,message = "Name must have minimum of 5 characters")
    private String categoryName;
}
