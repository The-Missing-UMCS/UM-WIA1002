package com.umwia1002.solution.tutorial.Tutorial6;

import java.util.Stack;

public class Q4_InfixToPostfix {
	public static void main(String[] args) {
		String exp = "( 4 + 3 ) * 5"; // ( 4 + 5 ) * 3 / ( 5 - 3 )
		Stack<String> stack = new Stack<>();

		for(String ch : exp.split("(\\s)+")) {
			if(isInteger(ch)) {
				System.out.print(ch + " ");
			} else {
				if(ch.equals("("))
					stack.push(ch);
				
				else if(ch.equals(")")) {
					String opr;
					while(!(opr = stack.pop()).equals("("))
						System.out.print(opr + " ");
				} 
				
				else {
					while(!stack.isEmpty() && !isValidSequence(stack.peek(), ch))
						System.out.print(stack.pop() + " ");
					stack.push(ch);
				}
			}
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
	
	public static boolean isInteger(String symbol) {
		try {
			Integer.parseInt(symbol);
			return true;
		} catch(NumberFormatException ex) {
			return false;
		}
	}
	
	public static int precedence(String opr) {
		switch(opr) {
		case "+", "-" : return 1;
		case "*", "/" : return 2;
		default: return 0;
		}
	}
	
	public static boolean isValidSequence(String stack, String ch) {
		return precedence(ch) >= precedence(stack);
	}
}
