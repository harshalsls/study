package com.study.all.rda.invoices;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceProblem {

    public static void main(String[] args) {
        List<Invoice> invoiceList = populateInvoiceList();
        a(invoiceList);
        b(invoiceList);
        c(invoiceList);
        d(invoiceList);
        e(invoiceList);
        f(invoiceList);
    }




    public static List<Invoice> populateInvoiceList() {
         return List.of(new Invoice("83", "Electric sander", 7, 57.98),
                new Invoice("24", "Power saw", 18, 99.99),
                new Invoice("7", "Sledge hammer", 11, 21.50),
                new Invoice("77", "Hammer", 76, 11.99),
                new Invoice("39", "Lawn mower", 3, 79.50),
                new Invoice("68", "Screwdriver", 106, 6.99),
                new Invoice("56", "Jig saw", 21, 11.00),
                new Invoice("3", "Wrench", 34, 7.50));

    }

    public static void a(List<Invoice> invoiceList) {
        System.out.println("Result of problem A : ");
        invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription)).
                forEach(System.out::println);
        System.out.println("");
    }

    public static void b(List<Invoice> invoiceList) {
        System.out.println("Result of problem B : ");
        invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPricePerItem)).
                forEach(System.out::println);
        System.out.println("");
    }

    public static void c(List<Invoice> invoiceList) {
        System.out.println("Result of problem C : ");
        Map<String, Integer> map = invoiceList.stream().collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity));
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("");

    }

    public static void d(List<Invoice> invoiceList) {
        System.out.println("Result of problem D : ");
        Map<String, Double> map = invoiceList.stream().collect(Collectors.toMap(Invoice::getPartDescription, s-> s.getQuantity() * s.getPricePerItem()));
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("");

    }

    public static void e(List<Invoice> invoiceList) {
        System.out.println("Result of problem E : ");
        Map<String, Double> map = invoiceList.stream().collect(Collectors.toMap(Invoice::getPartDescription, s-> s.getQuantity() * s.getPricePerItem()));
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).filter(stringDoubleEntry -> stringDoubleEntry.getValue() > 200 && stringDoubleEntry.getValue() < 500 ).forEach(System.out::println);
        System.out.println("");

    }

    public static void f(List<Invoice> invoiceList) {
        System.out.println("Result of problem F : ");
        Optional<Invoice> optionalInvoice = invoiceList.stream().filter(invoice -> invoice.getPartDescription().toLowerCase().contains("saw")).findAny();
        optionalInvoice.ifPresent(System.out::println);
        System.out.println("");

    }

}
