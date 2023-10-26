package com.study.all.study.dsa.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(7);
        printList(list);
        list.addAtHead(2);
        printList(list);
        list.addAtHead(1);
        printList(list);
        list.addAtIndex(3,0);

        printList(list);



    }

    public static void printList(MyLinkedList list) {
        MyLinkedList temp = list.head;
        while (temp != null) {
            System.out.print("-> "+temp.val);
            temp = temp.next;
        }
    }

}
