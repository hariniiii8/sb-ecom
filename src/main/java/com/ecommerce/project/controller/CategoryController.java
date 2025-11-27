package com.ecommerce.project.controller;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    //@RequestMapping(value = "/public/categories",method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getCategories()
    {
        CategoryResponse cats= categoryService.getCategories();
        return new ResponseEntity<>(cats,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestMapping(value = "/public/categories",method = RequestMethod.POST)
    public ResponseEntity<String> addCategories(@Valid @RequestBody Category c)
    {
        categoryService.createCategory(c);
        return new ResponseEntity<>("Category created successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId)
    {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable Long categoryId)
    {
            categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Updated the category",HttpStatus.OK);

    }
}

