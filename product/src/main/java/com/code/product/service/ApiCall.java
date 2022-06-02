package com.code.product.service;

import com.code.product.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ApiCall {
    private static final Logger logger = LoggerFactory.getLogger(ApiCall.class);
    @Autowired
     RestTemplate restTemplate;

    private static final String categoryMisroserviceBaseURL =
            "http://category-service";

//  @CircuitBreaker(name = "example", fallbackMethod="fallback")
    public Category getCategoryDetails(Long categoryId) {
        logger.info("calling category microservice API using RestTemplate");
        Category category = restTemplate.getForObject(
                categoryMisroserviceBaseURL + "/category/id?id={categoryId}",
                Category.class, categoryId);
        return category;
    }
//    public Category fallback(Exception ex) {
//        logger.info("calling fallback and returning default course data");
//        Category course = new Category();
//        course.setId(1L);
//        course.setNom("common-course");
//        course.setDescription("a description for default category");
//        return course;
//    }
}
