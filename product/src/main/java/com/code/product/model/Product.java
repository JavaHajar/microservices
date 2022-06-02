package com.code.product.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;
    @Column(nullable = false, length = 90)
    private String description;
    @Column(nullable = false)
    private Float price;
    @Column(nullable = false)
    private Float oldPrice;
    private String image;
//    private Category category;

   private Long idCategory;


}
