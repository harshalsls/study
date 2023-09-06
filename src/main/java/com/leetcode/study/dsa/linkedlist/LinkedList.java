package com.leetcode.study.dsa.linkedlist;

import java.util.Objects;

public class LinkedList {

    private Node first;
    private Node last;


    public void addLast(int item) {
        Node node = new Node(item);

        if (Objects.isNull(first)) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int item) {
        Node newNode = new Node(item);
        newNode.next = first;
        first = newNode;
    }

    public void deleteFirst() {
        first = first.next;
    }

    public void deleteLast() {
        Node secondLast = first;
        Node iterator = first;
        while (iterator.next != null) {
            secondLast = iterator;
            iterator = iterator.next;
        }
        if (first == last) {
            throw new RuntimeException("There is only one element preset");
        }
        secondLast.next = null;
        last = secondLast;
    }

    public Boolean contains(Object item) {
        Node iterator = first;
        boolean doesContain = false;
        while (iterator.next != null) {
            if(!doesContain) {
                doesContain = iterator.value.equals(item);
            } else {
                return true;
            }
            iterator = iterator.next;
        }

        return doesContain;
    }

    public int indexOf(Object item) {
        Node iterator = first;
        boolean doesContain = false;
        int index = 0;
        while (iterator.next != null) {
            doesContain = iterator.value.equals(item);
            if(doesContain) {
                return index;
            }
            iterator = iterator.next;
            index++;
        }

        throw new RuntimeException("Item not found");
    }


    private class Node {
        private Integer value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
    }
}
