package com.umwia1002.solution.pastyear.PY2017_2.Q3;

import java.util.Stack;

public class BST<E extends Comparable<E>> {
    Node<E> root;
    int size;

    public boolean add(Node<E> node, E item) {
        Node<E> newNode = new Node<>(item);
        if (root == null) {
            root = node;
            size++;
        }

        Node<E> parent = root;
        int cmp = 0;
        for (Node<E> current = root; current != null;) {
            if ((cmp = item.compareTo(current.item)) == 0)
                return false;
            parent = current;
            current = cmp > 0 ? current.right : current.left;
        }

        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        size++;
        return true;
    }

    // Reference: https://github.com/JamesW0803/WIA1002pastyears/blob/main/twozerooneseven/BinarySearchTree.java
    public void printTreeInOrder() {
        if(root == null) {
            System.out.println("The tree is empty.");
        }
        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;

        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.item + " ");
                current = current.right;
            }
        }
    }

    public boolean contains(E item) {
        for(Node<E> node = root; node != null; ) {
            int cmp = item.compareTo(node.item);
            if(cmp == 0) return true;
            else node = cmp > 0 ? node.right : node.left;
        }
        return false;
    }
}
