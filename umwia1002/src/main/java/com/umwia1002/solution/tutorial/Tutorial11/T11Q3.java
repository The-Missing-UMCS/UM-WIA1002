package com.umwia1002.solution.tutorial.Tutorial11;

import com.umwia1002.solution.tutorial.Tutorial11.Tree.BST;

public class T11Q3 {
	public static void main(String[] args) {
		// T10Q2
		BST<Integer> tree = new BST<>();
		int[] arr = {50, 30, 25, 71, 80, 99, 40, 1, 7, 5};
		for(int i : arr)
			tree.add(i);
		tree.showTree();
		
		// T10Q3
		System.out.println("The height of the tree = " + tree.height());
		
	}
}
