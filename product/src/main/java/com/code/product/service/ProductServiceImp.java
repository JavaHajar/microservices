package com.code.product.service;

import com.code.product.model.Category;
import com.code.product.model.Product;
import com.code.product.repository.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepos productRepos;

    @Autowired
    ApiCall apiCall;

    @Override
    public List<Product> findAll() {
        return productRepos.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product product =  productRepos.findById(id).get();
//        Category category = apiCall.getCategoryDetails(product.getIdCategory());
        product.setIdCategory(apiCall.getCategoryDetails(product.getIdCategory()).getId());
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepos.deleteById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepos.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepos.save(product);
    }
}
