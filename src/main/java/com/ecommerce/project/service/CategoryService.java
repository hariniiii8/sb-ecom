package com.ecommerce.project.service;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    public CategoryResponse getCategories();

    public CategoryDTO createCategory(CategoryDTO c);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categorydto,Long categoryId);
}
