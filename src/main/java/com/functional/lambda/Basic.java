package com.functional.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basic {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable getUser = () -> {
            for (long i = 0; i < 10; i++) {

                UserService user = new UserService();
                System.out.println(user.getUser(i).getName());
            }
        };
        executorService.submit(getUser);

        List<User> userList = Arrays.asList(new User(1L,"Pranav", true), new User(2L, "Nizam", true), new User(3L, "Sarvesh", false));
        userList.stream().filter(user -> !user.getActive()).forEach(System.out::println);

        Integer sum = IntStream.rangeClosed(1,10).reduce(10,(a,b) -> a+b);
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1, 10).summaryStatistics();
        System.out.println(intSummaryStatistics.toString());

        String string = Stream.<String>builder().add("a").add("a").add("a").add("a").build().collect(Collectors.joining(",", "[","]"));
        System.out.println(string);

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        Map<Integer, List<Product>> collect = productList.stream().collect(Collectors.groupingBy(Product::getPrice));

        Map<Boolean, List<Product>> collect1 = productList.stream().collect(Collectors.partitioningBy(product -> product.getPrice() > 15));

        Set<Product> collect2 = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });


    }

}
