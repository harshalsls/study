package com.study.all.study.dsa.linkedlist;

public class MyLinkedList {

    MyLinkedList head;
    MyLinkedList next;
    int val;
    int size;

    public MyLinkedList() {

    }

    public int get(int index) {

        if (head == null) {
            return -1;
        }

        int count = 0;
        MyLinkedList temp = head;
        while (count < index) {
            if (temp.next == null) {
                return -1;
            }
            temp = temp.next;
            count++;
        }

        return temp.val;


    }

    public void addAtHead(int val) {
        if (head == null) {
            MyLinkedList temp = new MyLinkedList();
            temp.val = val;
            temp.next = null;
            head = temp; // head [1, null]
        } else {
            MyLinkedList temp = new MyLinkedList();
            temp.val = val;
            temp.next = head;
            head = temp;
        }
        size++;

    }

    public void addAtTail(int val) {
        if (head == null) {
            MyLinkedList temp = new MyLinkedList();
            temp.val = val;
            head = temp;
        } else {

            MyLinkedList temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            MyLinkedList newTail = new MyLinkedList();
            newTail.val = val;
            temp.next = newTail; // [1,2] [2, null]
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        }
        int count = 0;
        MyLinkedList prev = new MyLinkedList();
        MyLinkedList temp = head;
        while (count <= index) {
            if (temp.next == null) {
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        prev.next = newNode;
        newNode.next = temp; // [1,2], [2,3] , [3, null]
        size++;
    }

    public void deleteAtIndex(int index) {
        if (size > index) {
            if (index == 0) {
                head = head.next;
            } else {
                int count = 0;
                MyLinkedList prev = new MyLinkedList();
                MyLinkedList temp = head;
                while (count <= index - 1) {
                    if (temp == null) {
                        break;
                    }
                    prev = temp;
                    temp = temp.next;
                    count++;
                }

                prev.next = temp.next;
                size--;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
