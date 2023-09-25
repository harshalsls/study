package com.study.all.rda.binarytree;

import java.util.Objects;
import java.util.Stack;

public class BinaryTreeUsingStack {

    public static void main(String[] args) {

        Node mainNode = new Node("");

        Stack<String> binaryStack = new Stack<>();
        NodeTree(3, mainNode, binaryStack);
        System.out.println(mainNode);
    }

    public static void NodeTree(int n, Node node, Stack<String> binaryStack) {

        if (n == 0) {
            node.value = createStringFromStackValues(binaryStack);
            return;
        }

        //stack push
        binaryStack.push("0");
        node.left = new Node(node.value + "0" );
        NodeTree(n - 1, node.left, binaryStack);
        //stack pop
        binaryStack.pop();


        //stack push
        binaryStack.push("1");
        node.right = new Node(node.value + "1");
        NodeTree(n - 1, node.right, binaryStack);
        //stack pop
        binaryStack.pop();
    }

    public static String createStringFromStackValues(Stack<String> binaryStack) {
        StringBuilder stringBuilder = new StringBuilder();
        binaryStack.forEach(stringBuilder::append);
        return stringBuilder.toString();
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

