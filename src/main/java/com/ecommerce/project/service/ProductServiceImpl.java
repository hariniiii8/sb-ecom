package com.ecommerce.project.service;

import com.ecommerce.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;
}
