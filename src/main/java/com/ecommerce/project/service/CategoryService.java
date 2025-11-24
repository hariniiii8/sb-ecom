package com.ecommerce.project.service;

import com.ecommerce.project.models.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getCategories();

    public void createCategory(Category c);

    String deleteCategory(Long categoryId);

    void updateCategory(Category category,Long categoryId);
}
