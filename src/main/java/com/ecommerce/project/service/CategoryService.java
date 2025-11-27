package com.ecommerce.project.service;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    public CategoryResponse getCategories();

    public void createCategory(Category c);

    String deleteCategory(Long categoryId);

    void updateCategory(Category category,Long categoryId);
}
