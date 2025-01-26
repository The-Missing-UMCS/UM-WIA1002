package com.umwia1002.solution.lab.version2.lab5.Q4;

import java.util.Stack;
public class Q4 {
	public static void main(String[] args) {
		String[] messages = {
				"System.out.println(str.charAt(3);", "System.out.print(\"\\( No Error\")",
				"int[] num = 1, 2};", "if (arr[{3] < 4)"};
				
		
		for(String line : messages) {
			System.out.println("Enter an expression: " + line);
			correctMatch(line);
			System.out.println();
		}
		
	}
	
	public static boolean hasCorrespond(Stack<Character> stack, char closed) {
		int diff = closed - stack.peek();
		return diff == 1 || diff == 2;
	}
	
	public static boolean isLeft(char ch) {
		return ch == '(' || ch == '{' || ch == '[';
	}
	
	public static boolean isRight(char ch) {
		return ch == ')' || ch == '}' || ch == ']';
	}
	
	public static char correspondLeft(char ch) {
		return ch > 50 ? (char) (ch - 2) : (char) (ch - 1);
	}
	
	public static char correspondRight(char ch) {
		return ch > 50 ? (char) (ch + 2) : (char) (ch + 1);
	}
	
	public static void correctMatch(String input) {
		Stack<Character> stack = new Stack<>();
		char[] chars = input.toCharArray();
		int n = input.length();
		boolean hasError = false;
		
		System.out.println(input);
		
		int i;
		for(i = 0; i < n && !hasError; i++) {
			char ch = chars[i];
			
			if(chars[i] == '\\')
				i++;
			
			else if (isLeft(ch))
				stack.push(ch);
			
			else if (isRight(ch)) {
				if(stack.empty()) {
					System.out.println(" ".repeat(i) + "^ Extra " + ch);
					hasError = true;
				}
				
				else {
					if(hasCorrespond(stack, ch))
						stack.pop();
					
					else {
						System.out.println(" ".repeat(i) + "^ Missing " + correspondRight(stack.peek()));
						hasError = true;
					}
				}
			}	
		}
		
		if(!hasError) {
			if(stack.size() > 0)
				System.out.println(" ".repeat(i - 1) + "^ Missing " + correspondRight(stack.pop()));
			else 
				System.out.println("The expression is balanced");
		}
			
	}
}
