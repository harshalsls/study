package com.epam.task.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Order {

    private Long orderId;

    private Customer customer;

    List<Product> products;

    LocalDate orderDate;

    public Order(Long orderId, Customer customer, List<Product> products, LocalDate orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.orderDate = orderDate;
    }
}
