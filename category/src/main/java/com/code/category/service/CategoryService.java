package com.code.category.service;

import com.code.category.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    public List<Category> findAll();
    public Optional<Category> findById(Long id);
    public void delete(Long id);
    public Category save(Category category);
    public Category update(Category category);
}
