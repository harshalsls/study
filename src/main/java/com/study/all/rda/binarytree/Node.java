package com.study.all.rda.binarytree;

import lombok.Data;

@Data
public class Node {
    public Node left;
    public String value;
    public Node right;

    public Node(Node left, String value, Node right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    public Node(String value) {
        this.left = null;
        this.value = value;
        this.right = null;
    }
}
