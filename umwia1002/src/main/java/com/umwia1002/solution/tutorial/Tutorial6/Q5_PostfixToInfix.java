package com.umwia1002.solution.tutorial.Tutorial6;

import java.util.Stack;

public class Q5_PostfixToInfix {
	public static void main(String[] args) {
		String exp = "4 5 + 3 5 3 - / * ";
		Stack<Expression> stack = new Stack<>();
		
		for(String ch : exp.split("\\s+")) {
			if(isInteger(ch))
				stack.push(Expression.newOperand(ch));
			else
				stack.push(Expression.newOperation(stack.pop(), stack.pop(), ch));
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getExpression());
		}
	}

	public static boolean isInteger(String ch) {
		try {
			Integer.parseInt(ch);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}

class Expression {
	private String operator;
	private String operation;
	private int bracketLvl;

	private Expression(String operator, String operation, int bracketLvl) {
		this.operator = operator;
		this.operation = operation;
		this.bracketLvl = bracketLvl;
	}
	
	public String getExpression() {
		return operation;
	}

	public static Expression newOperand(String ch) {
		return new Expression(null, ch, 0);
	}

	public static Expression newOperation(Expression right, Expression left, String operator) {
		StringBuilder sb = new StringBuilder();
		boolean hasBracket = false;
		
		if (left.operator != null && precedence(operator) > precedence(left.operator)) {
			sb.append(bracket(left));
			hasBracket = true;
		} else
			sb.append(left.operation);

		sb.append(' ').append(operator).append(' ');

		if (right.operator != null && precedence(operator) > precedence(right.operator)) {
			sb.append(bracket(right));
			hasBracket = true;
		} else
			sb.append(right.operation);
		
		int bracketLvl = Math.max(right.bracketLvl, left.bracketLvl) + ((hasBracket) ? 1 : 0);
		return new Expression(operator, sb.toString(), bracketLvl);
	}

	private static int precedence(String operator) {
		switch (operator) {
		case "+", "-":
			return 1;
		case "*", "/":
			return 2;
		default:
			return 0;
		}
	}

	private static String bracket(Expression exp) {
		String[] brackets = getBracket(exp.bracketLvl);
		return String.format("%s%s%s", brackets[0], exp.operation, brackets[1]);
	}

	private static String[] getBracket(int bracketLvl) {
		switch (bracketLvl % 3) {
		case 0:
			return new String[] { "(", ")" };
		case 1:
			return new String[] { "{", "}" };
		case 2:
			return new String[] { "[", "]" };
		default:
			return new String[] { "(", ")" };
		}
	}
}
