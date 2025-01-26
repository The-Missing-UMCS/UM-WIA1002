package com.umwia1002.solution.lab.version2.lab5.Q2;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		long longWait = 1000;
		long shortWait = 700;
		String[] infixArray, postfixArray;
		try (Scanner sc = new Scanner(new File("./src/Lab5/Q2/question.txt"))) {
			while(sc.hasNextLine()) {
				System.out.print("Enter infix expression : ");
				Thread.sleep(longWait);
				String expression = sc.nextLine();
				System.out.println(expression);
				
				// b.
				Thread.sleep(shortWait);
				infixArray = toInfixArray(expression);
				System.out.print("The infix expression is: ");
				Thread.sleep(shortWait);
				System.out.println(String.join(" ", infixArray));
				
				// c.
				Thread.sleep(shortWait);
				postfixArray = infixToPostfix(infixArray);
				System.out.print("The postfix expression is: ");
				Thread.sleep(shortWait);
				System.out.println(String.join(" ", postfixArray));
				
				// d.
				Thread.sleep(shortWait);
				System.out.print("The result is: ");
				Thread.sleep(shortWait);
				System.out.println(evaluatePostfix(postfixArray) + "\n");
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String[] toInfixArray(String str) {
		String[] arr = str.split("\\s");
		for (int i = 0; i < arr.length; i++)
			if (!isInteger(arr[i]))
				arr[i] = symbolConverter(arr[i]);
		return arr;
	}
	
	public static int evaluatePostfix(String[] postfixArray) {
		Stack<Integer> stack = new Stack<>();
		for(String exp : postfixArray) {
			if(isInteger(exp))
				stack.push(Integer.parseInt(exp));
			else
				stack.push(operation(stack.pop(), stack.pop(), exp));
		}
		
		return stack.pop();
	}

	public static String[] infixToPostfix(String[] infixArray) {
		ArrayList<String> postArr = new ArrayList<>();
		Stack<String> stack = new Stack<>();

		for (String exp : infixArray) {
			if (isInteger(exp)) {
				postArr.add(exp); // If it is an operand, output
			} else {
				if (exp.equals("(")) { 
					stack.push(exp); // When ( is found, push.
				}
				
				// When ) is found, pop until the matching (.
				else if (exp.equals(")")) {
					String operator;
					while (!(operator = stack.pop()).equals("("))
						postArr.add(operator);
				}

				// pop until the stacks has a lower precedence operator
				else {
					while (!stack.empty() && !isValidSequence(stack.peek(), exp))
						postArr.add(stack.pop());
					stack.push(exp); // then, push the new operator
				}
			}
		}

		// When reach the end of input, pop until the stacks is empty.
		while (!stack.empty())
			postArr.add(stack.pop());

		return postArr.toArray(new String[postArr.size()]);
	}
	
	public static int operation(int opr2, int opr1, String operator) {
		switch (operator) {
		case "+" : return opr1 + opr2;
		case "-" : return opr1 - opr2;
		case "*" : return opr1 * opr2;
		case "/" : return opr1 / opr2;
		case "%" : return opr1 % opr2;
		default  : return 0;
		}
	}

	public static String symbolConverter(String operator) {
		switch (operator) {
		case "add": return "+";
		case "sub": return "-";
		case "mul": return "*";
		case "div": return "/";
		case "mod": return "%";
		case "ob": 	return "(";
		case "cb": 	return ")";
		default: 	return " ";
		}
	}

	public static boolean isInteger(String operand) {
		try {
			Integer.parseInt(operand);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static int precedence(String operator) {
		switch (operator) {
		case "+" : return 1;
		case "-" : return 1;
		case "/" : return 2;
		case "*" : return 2;
		case "%" : return 2;
		default:  return 0;
		}
	}

	public static boolean isValidSequence(String inside, String outside) {
		return precedence(outside) >= precedence(inside);
	}
}
