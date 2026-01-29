package com.umwia1002.solution.tutorial.tutorial11;

import com.umwia1002.solution.tutorial.tutorial11.Tree.BST;

public class t11q2 {
    /*
     *            50
     *           /  \
     *          /    \
     *         /      \
     *	      30       71
     *       /  \        \
     *	    25   40       80
     *     /                \
     *    1                  99
     *	   \
     *      7
     *     /
     *     5
     *
     */

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        int[] arr = {50, 30, 25, 71, 80, 99, 40, 1, 7, 5};
        for (int i : arr) {
            tree.add(i);
        }
        tree.showTree();
    }
}
