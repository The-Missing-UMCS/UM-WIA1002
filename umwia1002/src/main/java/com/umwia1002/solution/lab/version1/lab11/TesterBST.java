package com.umwia1002.solution.lab.version1.lab11;

public class TesterBST {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();

        int[] input = {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        System.out.print("Input Data: ");
        for (int i : input) {
            System.out.print(i + ", ");
            bst.insert(i);
        }
        System.out.println();

        System.out.print("Inorder (sorted): ");
        bst.inOrder();
        System.out.println();

        System.out.print("Postorder: ");
        bst.postOrder();
        System.out.println();

        System.out.print("Preorder: ");
        bst.preOrder();
        System.out.println();

        System.out.println("Height of BST: " + bst.height());
        System.out.println("Root for BST is: " + bst.getRoot());
        System.out.println("Check whether 10 is in the tree? " + bst.search(10));

        System.out.println("Delete 53");
        bst.delete(53);

        System.out.print("Updated Inorder data (sorted): ");
        bst.inOrder();
        System.out.println();

        System.out.println("Min Value: " + bst.minValue());
        System.out.println("Max Value: " + bst.maxValue());

        System.out.print("A path from the root to 6 is: ");
        for (TreeNode<Integer> node : bst.path(6))
            System.out.print(node.elem + " ");
        System.out.println();
	}
}
