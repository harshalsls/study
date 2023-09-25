package com.study.all.rda.binarytree;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public static void main(String[] args) {

        // Create a Queue with the input numbers
        Queue<String> mBinaryQueue = new ArrayDeque<>(List.of("000", "001", "010", "011", "100", "101", "110", "111"));

        Node mainNode = new Node(null, "0", null);
        NodeTree(3, mainNode, mBinaryQueue);
        System.out.println(mainNode);

    }

    public static void NodeTree(int n, Node node, Queue<String> mBinaryStack) {

        if (n == 1) {
            node.left = new Node(null, mBinaryStack.poll(), null);
            node.right = new Node(null, mBinaryStack.poll(), null);
            return;
        }


        node.left = new Node(null, "0", null);
        NodeTree(n - 1, node.left, mBinaryStack);

        node.right = new Node(null, "1", null);
        NodeTree(n - 1, node.right, mBinaryStack);

    }
}

