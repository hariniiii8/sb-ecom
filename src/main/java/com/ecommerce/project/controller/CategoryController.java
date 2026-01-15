package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.persistence.criteria.CriteriaBuilder;
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

//    @GetMapping("/echo")
//    public ResponseEntity<String> echo(@RequestParam(name = "message",defaultValue = "Hello World") String message)
//    {
//        return new ResponseEntity<>("Echoed message: "+message,HttpStatus.OK);
//    }

    @GetMapping("/public/categories")
    //@RequestMapping(value = "/public/categories",method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getCategories(@RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
                                                          @RequestParam(name="pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
                                                          @RequestParam(name="sortBy",defaultValue = AppConstants.SORT_CATEGORIES_BY,required = false) String sortBy,
                                                          @RequestParam(name="sortOrder",defaultValue = AppConstants.SORT_DIR,required = false) String sortOrder)

    {
        CategoryResponse cats= categoryService.getCategories(pageNumber,pageSize,sortBy,sortOrder);
        return new ResponseEntity<>(cats,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestMapping(value = "/public/categories",method = RequestMethod.POST)
    public ResponseEntity<CategoryDTO> addCategories(@Valid @RequestBody CategoryDTO c)
    {
        CategoryDTO categoryDTO=categoryService.createCategory(c);
        return new ResponseEntity<>(categoryDTO,HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId)
    {
            CategoryDTO categoryDTO= categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categorydto, @PathVariable Long categoryId)
    {
        CategoryDTO cat=categoryService.updateCategory(categorydto,categoryId);
            return new ResponseEntity<>(cat,HttpStatus.OK);

    }
}

