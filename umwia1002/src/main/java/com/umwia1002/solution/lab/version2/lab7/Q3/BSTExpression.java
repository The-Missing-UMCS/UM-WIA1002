package com.umwia1002.solution.lab.version2.lab7.Q3;

import java.util.*;

public class BSTExpression {
	private static class Node {
		String val;
		Node left;
		Node right;

		Node(String val) {
			this(val, null, null);
		}

		Node(String val, Node right, Node left) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private Node head;
	private int size;
	private String expression;
	private Queue<String> postfix;

	private BSTExpression(String expression) {
		this.expression = expression;
		this.postfix = infixToPostFix(expToInfix(expression));
		this.size = postfix.size();
		this.head = postfixToTree(this.postfix);
	}

	public static BSTExpression create(String expression) {
		if (isValidExpression(expression)) {
			return new BSTExpression(expression);
		} else {
			throw new IllegalStateException(expression);
		}
	}

	public int getSize() {
		return this.size;
	}

	public String getExpression() {
		return this.expression;
	}

	public String getPostfix() {
		return String.join(" ", postfix.toArray(String[]::new));
	}

	public void preOrder() {
		preOrder(this.head);
		System.out.println();
	}

	private void preOrder(Node head) {
		if (head != null) {
			preOrder(head.left);
			preOrder(head.right);
			System.out.printf(" <-- %s ", head.val);
		}
	}

	public void inOrder() {
		inOrder(this.head);
		System.out.println();
	}

	private void inOrder(Node head) {
		if (head != null) {
			inOrder(head.left);
			System.out.printf(" <-- %s ", head.val);
			inOrder(head.right);
		}
	}

	public void postOrder() {
		postOrder(this.head);
		System.out.println();
	}

	private void postOrder(Node head) {
		if (head != null) {
			System.out.printf(" <-- %s ", head.val);
			postOrder(head.left);
			postOrder(head.right);
		}
	}

	public static Queue<String> infixToPostFix(List<String> infix) {
		Stack<String> stack = new Stack<>();
		Queue<String> postfix = new LinkedList<>();

		for (String str : infix) {
			if (isInteger(str)) {
				postfix.add(str);
			} else {
				if (str.equals("(")) {
					stack.push(str);
				} else if (str.equals(")")) {
					while (!stack.peek().equals("(")) {
						postfix.add(stack.pop());
					}
				} else {
					while (!stack.empty() && precedence(stack.peek()) > precedence(str)) {
						postfix.add(stack.pop());
					}
					stack.push(str);
				}
			}
		}

		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}

		return postfix;
	}

	public static Node postfixToTree(Queue<String> postfix) {
		Stack<Node> stack = new Stack<>();
		while (!postfix.isEmpty()) {
			String str = postfix.poll();
			if (isInteger(str)) {
				stack.push(new Node(str));
			} else {
				stack.push(new Node(str, stack.pop(), stack.pop()));
			}
		}
		return stack.pop();
	}

	private static int precedence(String str) {
		switch (str) {
			case "+", "-":
				return 1;
			case "*", "/":
				return 2;
			default:
				return 0;
		}
	}

	private static boolean isInteger(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public static boolean isOperator(char ch) {
		return String.valueOf(ch).matches("[+\\-*/]");
	}

	private static List<String> expToInfix(String exp) {
		List<String> list = new ArrayList<>();
		StringBuilder number = new StringBuilder();
		for (char ch : exp.toCharArray()) {
			if (Character.isDigit(ch)) {
				number.append(ch);
			} else {
				if (number.length() > 0) {
					list.add(number.toString());
					number = new StringBuilder();
				}
				if (isOperator(ch)) {
					list.add(String.valueOf(ch));
				}
			}
		}

		if (!number.isEmpty()) {
			list.add(number.toString());
		}
		return list;
	}

	public static boolean isValidExpression(String exp) {
		for (char ch : exp.toCharArray()) {
			if (!(Character.isDigit(ch) ||
					Character.isWhitespace(ch) ||
					isOperator(ch) ||
					ch == '(' || ch == ')'))
				return false;
		}
		return true;
	}
}
