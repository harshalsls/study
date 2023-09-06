package com.epam.task.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private Long customerId;
    private String customerName;

    public Customer(Long customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }
}
