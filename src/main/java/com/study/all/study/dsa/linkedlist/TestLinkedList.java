package com.study.all.study.dsa.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(40);
        list.deleteFirst();
        list.deleteLast();

        Boolean doesContains = list.contains(40);
        System.out.println(doesContains);
        System.out.println(list.indexOf(20));

    }
}
