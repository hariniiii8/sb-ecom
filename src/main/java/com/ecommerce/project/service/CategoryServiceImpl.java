package com.ecommerce.project.service;

import com.ecommerce.project.exception.APIException;
import com.ecommerce.project.exception.ResourceNotFoundException;
import com.ecommerce.project.models.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    //private List<Category> categories =new ArrayList<>();

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category c) {
        Category toSave= categoryRepository.findByCategoryName(c.getCategoryName());
        if(toSave!=null)
        {
            throw new APIException("Category already exists");
        }
        categoryRepository.save(c);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(
                ()->new ResourceNotFoundException("Category","CategoryId",categoryId)
        );

        categoryRepository.delete(category);

        return "Deleted successfully";
    }
    public void updateCategory(Category category,Long categoryId)
    {
        Category savedCategory=categoryRepository.findById(categoryId).orElseThrow(
                ()->new ResourceNotFoundException("Category","CategoryId",categoryId)
        );
        category.setCategoryId(categoryId);
        categoryRepository.save(category);

    }
}
