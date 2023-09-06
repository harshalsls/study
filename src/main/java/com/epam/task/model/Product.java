package com.epam.task.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long productId;

    private String productName;

    private Category category;


    public Product(Long productId, String productName, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
