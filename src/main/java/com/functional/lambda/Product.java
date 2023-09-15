package com.functional.lambda;

import lombok.Data;

@Data
public class Product {

    private Integer price;
    private String name;

    public Product(Integer price, String name) {
        this.price = price;
        this.name = name;
    }
}
