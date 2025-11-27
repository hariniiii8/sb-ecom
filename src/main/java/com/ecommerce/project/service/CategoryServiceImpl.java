package com.ecommerce.project.service;

import com.ecommerce.project.exception.APIException;
import com.ecommerce.project.exception.ResourceNotFoundException;
import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;
    //private List<Category> categories =new ArrayList<>();

    @Override
    public CategoryResponse getCategories() {
        List<Category> categories= categoryRepository.findAll();
        if(categories.isEmpty())
        {
            throw new APIException("No Categories present");
        }
        List<CategoryDTO> categoryDTOList= categories.stream().map(
                category -> modelMapper.map(category,CategoryDTO.class)
        ).toList();
        CategoryResponse categoryResponse=new CategoryResponse();
        categoryResponse.setContent(categoryDTOList);
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category c=modelMapper.map(categoryDTO,Category.class);
        Category toSave= categoryRepository.findByCategoryName(c.getCategoryName());
        if(toSave!=null)
        {
            throw new APIException("Category already exists");
        }
        Category saved=categoryRepository.save(c);
        CategoryDTO categoryDT=modelMapper.map(saved,CategoryDTO.class);
        return categoryDT;
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
