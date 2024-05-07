package com.youtube.ecommerce.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private List<Product> products;

    // getters and setters
}