package com.umwia1002.solution.lab.version2.lab07.l7q1;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {

    Node<E> root;
    int size;

    public void insert(E e) {
        Node<E> newNode = new Node<E>(e);
        if (root == null) {
            root = newNode;
        } else {
            Node<E> parent = root;
            int value = 0;

            for (Node<E> child = root; child != null; ) {
                if ((value = e.compareTo(child.item)) == 0) {
                    child.occ++;
                    break;
                }
                parent = child;
                child = value > 0 ? child.right : child.left;
            }

            if (value > 0) {
                parent.right = newNode;
            } else if (value < 0) {
                parent.left = newNode;
            }
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public E getRoot() {
        return root.item;
    }

    public E minValue() {
        Node<E> node = root;
        for (; node.left != null; node = node.left) {
        }
        return node.item;
    }

    public E maxValue() {
        Node<E> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.item;
    }

    public ArrayList<Node<E>> path(E e) {
        if (root == null) {
            return null;
        }

        ArrayList<Node<E>> path = new ArrayList<Node<E>>();
        for (Node<E> node = root; node != null; ) {
            path.add(node);
            if (e.compareTo(node.item) == 0) {
                break;
            }
            node = e.compareTo(node.item) > 0 ? node.right : node.left;
        }

        return path.get(path.size() - 1).item.compareTo(e) == 0 ? path : null;
    }

    public boolean delete(E e) {
        // Find the node
        Node<E> parent = root;
        Node<E> node = root;

        while (node != null) {
            if (node.item.compareTo(e) == 0) {
                break;
            }
            parent = node;
            node = e.compareTo(node.item) > 0 ? node.right : node.left;
        }

        if (node == null) {
            return false;
        }

        if (node.occ > 1) {
            node.occ--;
        } else {
            // Delete accordingly
            if (node.left == null) {
                if (node.item.compareTo(parent.item) > 0) {
                    parent.right = node.right;
                } else {
                    parent.left = node.right;
                }
            } else {
                Node<E> rightMost = node.left;
                Node<E> parentOfRight = node;
                while (rightMost.right != null) {
                    parentOfRight = rightMost;
                    rightMost = rightMost.right;
                }

                node.item = rightMost.item;

                // If the "rightMost" is on the right side, then change the parentOfRight.right
                // else, (e.g: when the while loop is never execute), change the parentOfRight.left
                if (parentOfRight.right.compareTo(rightMost) == 0) {
                    parentOfRight.right = rightMost.left;
                } else {
                    parentOfRight.left = rightMost.left;
                }
            }
        }

        size--;
        return true;
    }

    public int getOccurence(E e) {
        for (Node<E> node = root; node != null; ) {
            if (e.compareTo(node.item) == 0) {
                return node.occ;
            }
            node = e.compareTo(node.item) > 0 ? node.right : node.left;
        }
        return 0;
    }

    public boolean clear() {
        if (root == null && size == 0) {
            return false;
        }
        Node<E> node = root;
        root = null;
        clear(node);
        size = 0;
        return true;
    }

    private void clear(Node<E> node) {
        if (node != null) {
            clear(node.left);
            clear(node.right);
            node.item = null;
            node.occ = 0;
            node.left = node.right = null; // Helps GC
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.item + " --> ");
            inOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.item + " --> ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node<E> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.item + " --> ");
        }
    }
}
