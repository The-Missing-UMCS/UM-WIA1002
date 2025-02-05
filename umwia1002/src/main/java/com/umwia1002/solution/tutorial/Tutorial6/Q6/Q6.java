package com.umwia1002.solution.tutorial.Tutorial6.Q6;

import java.util.Stack;

public class Q6 {
	public static void main(String[] args) {
		towerOfHanoi(3, 'A', 'C', 'B');
		System.out.println(factorial(5));
		infixToPostfix("( 4 + 3 ) * 5");
	}
	
	public static int factorial(int i) {
		if(i == 1 || i == 0)
			return 1;
		else 
			return i * factorial(i - 1);
	}
	
	public static void towerOfHanoi(int disc, char src, char dst, char aux) {
		if(disc == 1) {
			System.out.printf("Disc %d: %c --> %c\n", disc, src, dst);
		} else {
			towerOfHanoi(disc - 1, src, aux, dst);
			System.out.printf("Disc %d: %c --> %c\n", disc, src, dst);
			towerOfHanoi(disc - 1, aux, dst, src);
		}
	}
	
	public static void infixToPostfix(String exp) {
		Stack<String> stack = new Stack<>();
		for(String ch : exp.split("\\s")) {
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
	
	private static boolean isInteger(String ch) {
		try {
			Integer.parseInt(ch);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	private static int precedence(String ch) {
        return switch (ch) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
	}
	
	private static boolean isValidSequence(String stack, String ch) {
		return precedence(ch) >= precedence(stack);
	}
}
