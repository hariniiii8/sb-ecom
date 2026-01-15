package com.ecommerce.project.service;

import com.ecommerce.project.exception.APIException;
import com.ecommerce.project.exception.ResourceNotFoundException;
import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public CategoryResponse getCategories(Integer pageNumber,Integer pageSize) {
        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        Page<Category> page=categoryRepository.findAll(pageable);
        List<Category> categories= page.getContent();
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
        return modelMapper.map(saved,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(
                ()->new ResourceNotFoundException("Category","CategoryId",categoryId)
        );

        categoryRepository.delete(category);
        CategoryDTO categoryDTO=modelMapper.map(category,CategoryDTO.class);

        return categoryDTO;
    }
    public CategoryDTO updateCategory(CategoryDTO categorydto,Long categoryId)
    {
        Category category=modelMapper.map(categorydto,Category.class);
        Category savedCategory=categoryRepository.findById(categoryId).orElseThrow(
                ()->new ResourceNotFoundException("Category","CategoryId",categoryId)
        );
        category.setCategoryId(categoryId);
        Category saved=categoryRepository.save(category);
        CategoryDTO categoryDTO=modelMapper.map(saved,CategoryDTO.class);
        return categoryDTO;

    }
}
