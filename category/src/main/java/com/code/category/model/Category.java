package com.code.category.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor

@Entity
public class Category {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;
    @Column(nullable = false, length = 90)
    private String description;
    private String image;
}
