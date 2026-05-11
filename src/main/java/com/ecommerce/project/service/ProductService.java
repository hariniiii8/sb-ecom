package com.ecommerce.project.service;

import com.ecommerce.project.models.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.repositories.ProductRepository;
import org.springframework.stereotype.Service;


public interface ProductService {

    ProductDTO addProduct(Long categoryId, Product product);
}
