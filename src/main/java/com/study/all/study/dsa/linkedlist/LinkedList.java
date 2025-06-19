package com.study.all.study.dsa.linkedlist;





public class LinkedList {

    private LinkedList head;
    private LinkedList next;
    int val;
    int size;


    public LinkedList() {

    }

    public int get(int index) {

        if (head == null) {
            return -1;
        }

        int count = 0;
        LinkedList current = head;
        while (count < index) {

            current = current.next;
            count++;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        LinkedList linkedList = new LinkedList();
        linkedList.val = val;
        
        linkedList.next = head;
        head = linkedList;
        size++;
    }

    public void addAtTail(int val) {
        LinkedList cur = new LinkedList();
        cur.val = val;

        int count = 0;
        LinkedList current = head;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        current.next = cur;
        size++;
    }

    public void addAtIndex(int index, int val) {
        
        if(index < 0 || index > size) {
            return;
        }
        
        LinkedList cur = new LinkedList();
        cur.val = val;

        int count = 0;
        LinkedList current = head;
        while (count < index) {
            current = current.next;
            count++;
        }
        cur.next = current.next.next;
        current.next = cur;
        size++;
    }

    public void deleteAtIndex(int index) {
        int count = 0;
        LinkedList current = head;
        while (count < index) {
            current = current.next;
            count++;
        }
        current.next = current.next.next;
        size--;
        

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addAtHead(7);
        printList(list);
        list.addAtHead(2);
        printList(list);
        list.addAtHead(1);
        printList(list);
        list.addAtIndex(3, 0);

        printList(list);
    }
    public static void printList(LinkedList list) {
        LinkedList temp = list.head;
        while (temp != null) {
            System.out.print("-> "+temp.val);
            temp = temp.next;
        }
    }
    
}
