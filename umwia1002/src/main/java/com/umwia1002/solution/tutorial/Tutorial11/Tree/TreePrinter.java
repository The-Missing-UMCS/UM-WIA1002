package com.umwia1002.solution.tutorial.Tutorial11.Tree;

import java.util.*;

public class TreePrinter {
	// Referecnce: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java/8948691#8948691
	
	// Approach 1
	public static <E extends Comparable<E>> void printBinaryTree(TreeNode<E> root, int level) {
		if (root == null)
			return;
		printBinaryTree(root.right, level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++)
				System.out.print("|\t");
			System.out.println("|-------" + root.item);
		} else
			System.out.println(root.item);
		printBinaryTree(root.left, level + 1);
	}
	
	// Approach 2
	public static <E extends Comparable<E>> void print(String prefix, TreeNode<E> n, boolean isLeft) {
	    if (n != null) {
	        print(prefix + "     ", n.right, false);
	        System.out.println (prefix + ("|-- ") + n.item);
	        print(prefix + "     ", n.left, true);
	    }
	}
	
	// Approach 3 (Better)
	public static <E extends Comparable<E>> void print(BST<E> tree) {
		int height = tree.height();
		printNodeInternal(Collections.singletonList(tree.root), 1, height);
	}

	public static <E extends Comparable<E>> void printNodeInternal(List<TreeNode<E>> nodes, int level, int height) {
		if (nodes.isEmpty() || isAllElementsNull(nodes))
			return;

		int floor = height - level;
		int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
		int firstSpaces = (int) Math.pow(2, floor) - 1;
		int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

		System.out.print(whitespaces(firstSpaces));

		List<TreeNode<E>> newNodes = new ArrayList<>();
		for (TreeNode<E> node : nodes) {
			boolean isNullNode = node == null;
			System.out.print((isNullNode ? " " : node.item) + whitespaces(betweenSpaces));
			newNodes.add(isNullNode ? null : node.left);
			newNodes.add(isNullNode ? null : node.right);
		}

		System.out.println();

		for (int i = 1; i <= edgeLines; i++) {
			for (TreeNode<E> node : nodes) {
				System.out.print(whitespaces(firstSpaces - i));
				if (node == null)
					System.out.print(whitespaces((edgeLines * 2) + i + 1));
				else
					System.out.printf("%s%s%s%s", 
							node.left != null ? "/" : " ", whitespaces((i * 2) - 1),
							node.right != null ? "\\" : " ", whitespaces((edgeLines * 2) - i));
			}

			System.out.println();
		}
		printNodeInternal(newNodes, ++level, height);
	}

	private static String whitespaces(int count) {
		return " ".repeat(Math.max(0, count));
	}

	private static <E> boolean isAllElementsNull(List<E> list) {
		for (Object object : list)
			if (object != null)
				return false;
		return true;
	}
}
