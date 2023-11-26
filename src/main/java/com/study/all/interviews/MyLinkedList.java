package com.study.all.interviews;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

public class MyLinkedList<T> {

    private Node head = null;
    private Node tail = null;
    private int size;



    public void add(T t) {
        if(Objects.isNull(head)) {
            head = new Node(null, t);
            tail = head;
        } else {
            Node<T> newNode = new Node(null, t);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public Node<T> get(int index) {  // 4

        if(size < index +1) {
            System.out.println("List is not filled until the index provided");
        }

        Node<T> node = head.getNext();
        Node<T> indexNode = null;
        for (int i = 1; i <= index; i++) {
            indexNode = node.getNext();
        }
        return indexNode;
    }
}

@AllArgsConstructor
@Data
class Node<T> {
    private Node<T> next;
    private T value;
}