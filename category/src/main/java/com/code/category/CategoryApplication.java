package com.code.category;

import com.code.category.controller.CategoryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.File;
@EnableDiscoveryClient
@SpringBootApplication
public class CategoryApplication {


	public static void main(String[] args) {
		new File(CategoryController.uploadDirectory).mkdir();
		SpringApplication.run(CategoryApplication.class, args);
	}

}
