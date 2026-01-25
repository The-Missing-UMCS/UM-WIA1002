package com.umwia1002.solution.pastyear.py2017s2.Q3;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BST<Integer> binaryTree = new BST<>();

        // Testing add method
        System.out.println("Adding elements to the binary tree...");
        Node<Integer> root = new Node<>(50);
        binaryTree.add(root, 30);
        binaryTree.add(root, 70);
        binaryTree.add(root, 20);
        binaryTree.add(root, 40);
        binaryTree.add(root, 60);
        binaryTree.add(root, 80);

        // Testing printTreeInOrder method
        System.out.println("Printing binary tree in order:");
        binaryTree.printTreeInOrder();
        // binaryTree.inOrder(root);
        System.out.println();

        // Testing contains method
        System.out.println("Checking if tree contains certain elements...");
        System.out.println("Tree contains 50: " + binaryTree.contains(50));
        System.out.println("Tree contains 20: " + binaryTree.contains(20));
        System.out.println("Tree contains 100: " + binaryTree.contains(100));
    }
}

