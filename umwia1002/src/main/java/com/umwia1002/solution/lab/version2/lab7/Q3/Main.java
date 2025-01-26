package com.umwia1002.solution.lab.version2.lab7.Q3;

public class Main {
    public static void main(String[] args) {
		String exp;
		exp = "4+5*7";
		testExpression(exp);
		exp = "(5*4+8)/7+2";
		testExpression(exp);
		
	}

	public static void testExpression(String exp) {
		BSTExpression tree = BSTExpression.create(exp);
		System.out.println("Expression : " + tree.getExpression());
		System.out.println("The number of element in the tree : " + tree.getSize());
		System.out.print("The tree elements - INORDER : ");
		tree.inOrder();
		System.out.print("The tree elements - PREORDER : ");
		tree.preOrder();
		System.out.print("The tree elements - POSTRDER : ");
		tree.postOrder();
		System.out.println();
	}
}
