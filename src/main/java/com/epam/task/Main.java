package com.epam.task;

import com.epam.task.model.Category;
import com.epam.task.model.Customer;
import com.epam.task.model.Order;
import com.epam.task.model.Product;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        Category categoryFood = new Category(1L, "Food");
        Category categoryElectronics = new Category(2L, "Electronics");
        Category categoryHardware = new Category(3L, "Hardware");


        Customer customer1 = new Customer(1L, "Harshal Shinde");
        Customer customer2 = new Customer(2L, "Pranav Patil");
        Customer customer3 = new Customer(3L, "Somesh R");
        Customer customer4 = new Customer(4L, "Vijay P");

        Product productMilk = new Product(1L, "Milk", categoryFood);
        Product productSugar = new Product(2L, "Sugar", categoryFood);
        Product productMobile = new Product(3L, "Mobile", categoryElectronics);
        Product productLaptop = new Product(4L, "Laptop", categoryElectronics);
        Product productScrew = new Product(5L, "Screw Driver", categoryHardware);
        Product productWrench = new Product(6L, "Wrench", categoryHardware);




        Order order1 = new Order(1L, customer1, Arrays.asList(productMilk,productMobile,productScrew), LocalDate.now());
        Order order2 = new Order(2L, customer2, Arrays.asList(productSugar,productLaptop,productWrench), LocalDate.now());
        Order order3 = new Order(3L, customer3, Arrays.asList(productMilk,productWrench,productScrew), LocalDate.now());
        Order order4 = new Order(4L, customer4, Arrays.asList(productSugar,productMobile,productScrew), LocalDate.now());



        Map<Category, List<String>> groupCustomersByCategory = groupCustomersByCategory(Arrays.asList(order1, order2, order3, order4));

    }



    public static Map<Category, List<String>> groupCustomersByCategory(List<Order> orders) {

       return orders.stream().flatMap(order -> order.getProducts().stream()
                .map(product -> new AbstractMap.SimpleEntry<>(product.getCategory(), order.getCustomer()
                        .getCustomerName())))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.collectingAndThen(Collectors.toSet(), ArrayList::new))));

    }



}
