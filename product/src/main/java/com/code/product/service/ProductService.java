package com.code.product.service;

import com.code.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ProductService {
    public List<Product> findAll();
    public Product findById(Long id);
    public void delete(Long id);
    public Product save(Product product);
    public Product update(Product product);
}
