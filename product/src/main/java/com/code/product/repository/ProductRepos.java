package com.code.product.repository;

import com.code.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepos extends JpaRepository<Product, Long> {
}
