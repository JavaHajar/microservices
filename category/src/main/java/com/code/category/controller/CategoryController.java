package com.code.category.controller;

import com.code.category.model.Category;
import com.code.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();

    }

    @Autowired
    CategoryService categoryService;

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/imagedata";

    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return (List<Category>) categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Optional<Category> getOneCategory(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

    @PostMapping(value = "/createCategory")
    public Category createCategory(@RequestBody Category category){
//        StringBuilder fileNames = new StringBuilder();
//        String filename = category.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
//        Path fileNameAndPath = Paths.get(uploadDirectory, filename);
//        try {
//            Files.write(fileNameAndPath, file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        category.setImage(filename);
        return categoryService.save(category);
    }

    @PutMapping(value = "/updateCategory/{id}")
    public void updateCategory(@PathVariable("id") Long id , @RequestBody Category category){
        category.setId(id);
        categoryService.update(category);
    }
    @DeleteMapping("/deleteCategory/{id}")
    public void  deleteCategory(@PathVariable("id") Long id){
        categoryService.delete(id);
    }
}
