package com.study.all.rda.binarytree;

import java.util.Objects;

public class BinaryTree2 {

    public static void main(String[] args) {

        Node mainNode = new Node("");
        NodeTree(3, mainNode);
        System.out.println(mainNode);
    }

    public static void NodeTree(int n, Node node) {

        if (n == 0) {
            return;
        }

        node.left = new Node(node.value + "0" );
        NodeTree(n - 1, node.left);

        node.right = new Node(node.value + "1");
        NodeTree(n - 1, node.right);

    }

    public static void traverseTree(Node node) {

        if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
            System.out.println(node.value);
            return;
        }
        traverseTree(node.left);

        //TODO This will print intermediate node values eg 00 , 01.
        //TODO comment if only final values are required.
        System.out.println(node.value);

        traverseTree(node.right);


    }

}

