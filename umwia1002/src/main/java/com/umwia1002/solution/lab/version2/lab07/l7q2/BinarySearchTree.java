package com.umwia1002.solution.lab.version2.lab07.l7q2;

public class BinarySearchTree<E extends Comparable<E>> {

    static class TreeNode<E extends Comparable<E>> {

        E item;
        int frequency;
        TreeNode<E> left;
        TreeNode<E> right;

        TreeNode(E item) {
            this.item = item;
            this.frequency = 1;
        }
    }

    TreeNode<E> root;
    int size;

    public void add(E e) {
        TreeNode<E> newNode = new TreeNode<E>(e);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode<E> node = root;
            TreeNode<E> parent = root;
            int value = 0;

            while (node != null) {
                value = e.compareTo(node.item);
                if (value == 0) {
                    break;
                }
                parent = node;
                node = value > 0 ? node.right : node.left;
            }

            if (value > 0) {
                parent.right = newNode;
            } else if (value < 0) {
                parent.left = newNode;
            } else {
                node.frequency++;
            }

            size++;
        }
    }

    public void showFrequency() {
        showFrequency(root);
    }

    private void showFrequency(TreeNode<E> node) {
        if (node != null) {
            System.out.printf("%s %s -->\n", frequency(node), node.item);
            showFrequency(node.left);
            showFrequency(node.right);
        }
    }

    private String frequency(TreeNode<E> node) {
        int n = 4;
        for (int tmp = node.frequency; tmp > 0; tmp /= 10) {
            n--;
        }
        return "0".repeat(n) + node.frequency;
    }
}
