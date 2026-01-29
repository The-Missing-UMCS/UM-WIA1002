package com.umwia1002.solution.lab.version1.lab11;

import java.util.ArrayList;

public class BST<E extends Comparable<E>> {

    TreeNode<E> root;
    int size;

    public boolean search(E e) {
        return true;
    }

    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode<E>(e);
        } else {
            TreeNode<E> parent = root;
            int value = 0;

            for (TreeNode<E> node = root; node != null; ) {
                value = e.compareTo(node.elem);
                if (value == 0) {
                    return false;
                }
                parent = node;
                node = value < 0 ? node.left : node.right;
            }

            if (value < 0) {
                parent.left = new TreeNode<E>(e);
            } else {
                parent.right = new TreeNode<E>(e);
            }
        }

        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        // return (int) (ceil(log10(size) / log10(2)));
        return height(root);
    }

    private int height(TreeNode<E> node) {
        int height = -1;

        for (TreeNode<E> current = root; current != null; ) {
            height++;
            if (current.compareTo(node) == 0) {
                break;
            }
            current = node.compareTo(current) < 0 ? current.left : current.right;
        }
        return height;
    }

    public E getRoot() {
        return root.elem;
    }

    public E minValue() {
        for (TreeNode<E> min = root; min != null; min = min.left) {
            if (min.left == null) {
                return min.elem;
            }
        }
        return null;
    }

    public E maxValue() {
        for (TreeNode<E> max = root; max != null; max = max.right) {
            if (max.right == null) {
                return max.elem;
            }
        }
        return null;
    }

    public ArrayList<TreeNode<E>> path(E e) {
        if (root == null) {
            return null;
        }

        var path = new ArrayList<TreeNode<E>>();

        for (TreeNode<E> node = root; node != null; ) {
            path.add(node);
            if (node.elem.compareTo(e) == 0) {
                break;
            }
            node = e.compareTo(node.elem) < 0 ? node.left : node.right;
        }

        return path.getLast().elem.compareTo(e) == 0 ? path : null;
    }

    public boolean delete(E e) {
        // Find the node and its parent
        TreeNode<E> parent = null;
        TreeNode<E> node = root;

        while (node != null) {
            if (node.elem.compareTo(e) == 0) {
                break;
            }
            parent = node;
            node = e.compareTo(node.elem) < 0 ? node.left : node.right;
        }

        // Situation 1: No node at all
        if (node == null) {
            return false;
        }

        if (node.left == null) {
            if (parent == null) {
                root = node.right;
            }

            // If the node is a leaf, i.e, node.right == 0,
            // then parent will set either left/ right to null
            // If the node has only right child,
            // then parent will take replace its position with right child
            else if (parent.left.compareTo(node) == 0) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else {
            // Find the rightmost node
            TreeNode<E> parentRightMost = node;
            TreeNode<E> rightMost = node.left;

            while (rightMost.right != null) {
                parentRightMost = rightMost;
                rightMost = node.right;
            }

            // Replace the right most node with node
            node.elem = rightMost.elem;

            if (parentRightMost.right.compareTo(rightMost) == 0) {
                parentRightMost.right = rightMost.left;
            } else
            // Special case: parentRightMost == node
            // Not always the rightMost is on the right
            {
                parentRightMost.left = rightMost.left;
            }
        }

        size--;
        return true;
    }

    public boolean clear() {
        if (root == null && size == 0) {
            return false;
        }
        root = null;
        size = 0;
        return true;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode<E> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.elem + " ");
            inOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(TreeNode<E> node) {
        if (node != null) {
            System.out.print(node.elem + " ");
            inOrder(node.left);
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode<E> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.elem + " ");
        }
    }

}
