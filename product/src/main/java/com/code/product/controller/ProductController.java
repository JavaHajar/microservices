package com.code.product.controller;

import com.code.product.model.Product;
import com.code.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {


    @Autowired
    ProductService productService;

//    @GetMapping("/categories")
//    public List<Object> getStudents() {
//        Object[] objects = restTemplate().getForObject("http://student-microservice/students", Object[].class);
//        return Arrays.asList(objects);
//    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return (List<Product>) productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getOneProduct(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping(value = "/createProduct")
    public Product createProduct(@RequestBody Product product){
//        StringBuilder fileNames = new StringBuilder();
//        String filename = category.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
//        Path fileNameAndPath = Paths.get(uploadDirectory, filename);
//        try {
//            Files.write(fileNameAndPath, file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        category.setImage(filename);
        return productService.save(product);
    }

    @PutMapping(value = "/updateProduct/{id}")
    public void updateProduct(@PathVariable("id") Long id , @RequestBody Product product){
        product.setId(id);
        productService.update(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public void  deleteProduct(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
