package com.umwia1002.solution.tutorial.tutorial6.Q4;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        // Should return 4 3 + 5 *
        System.out.println(infixToPostfix("( 4 + 3 ) * 5"));

        // Should return 4 3 5 * +
        System.out.println(infixToPostfix("4 + 3 * 5"));

        // Should return 4 5 + 3 * 5 3 - /
        System.out.println(infixToPostfix("( 4 + 5 ) * 3 / ( 5 - 3 )"));
    }

    private static String infixToPostfix(String infixExpression) {
        Stack<String> operatorStack = new Stack<>();

        // Option 1: StringBuilder
        //  - Use StringBuilder instead of String.
        //  - StringBuilder is better because it avoids creating a new String object each time we add a character.
        //  - When we append a character to a String, a new object is created, which is inefficient and uses more memory.
        //  - In short, use StringBuilder when appending many characters.
        // Option 2: LinkedList
        //  - Use LinkedList to take advantage of the String.join() method.
        //  - Use LinkedList instead of ArrayList because we mainly use the add() methods.
        List<String> postfix = new LinkedList<>();

        // .trim() removes leading and trailing whitespaces
        //  e.g. "  4 + 3  " -> "4 + 3"
        //  e.g. "  4 - 3  " -> "4 - 3"
        //
        // .split("(\\s)+") splits the string by one or more whitespaces
        // 	e.g. "4 + 3" -> ["4", "+", "3"]
        // 	e.g. "4 -     3" -> ["4", "-", "3"]
        for (String ch : infixExpression.trim().split("(\\s)+")) {
            if (isInteger(ch)) {
                postfix.add(ch);
            } else {
                // We use .equals() instead of == to compare the values of the strings.
                // Using == checks the memory references, which usually returns false for different string objects.
                // Also, we write "(".equals(ch) instead of ch.equals("(") to avoid a NullPointerException if ch is null.
                // Although ch cannot be null in this case, it is a good practice to write it this way.
                if ("(".equals(ch)) {
                    operatorStack.push(ch);
                } else if (")".equals(ch)) {
                    // stack.peek() returns the top element of the stack without removing it
                    while (!"(".equals(operatorStack.peek())) {
                        postfix.add(operatorStack.pop());
                    }
                    // To remove the "(" from the stack
                    operatorStack.pop();
                } else {
                    // 1. If the stack is empty, push the operator onto the stack, regardless of precedence.
                    //
                    // 2. If the stack is not empty and the current operator has higher precedence than the one on top of the stack,
                    //    push it onto the stack since it takes priority.
                    //
                    // 3. If the current operator has lower precedence, pop operators from the stack
                    //    until the top operator has lower precedence than the current one.
                    //    This ensures that operators with higher precedence are processed first.

                    while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                        postfix.add(operatorStack.pop());
                    }
                    operatorStack.push(ch);
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.add(operatorStack.pop());
        }

        // String.join(" ") concatenates the elements of the postfix list with a space between each element
        // e.g. String.join(" ", ["4", "3", "+", "5", "*"]) -> "4 3 + 5 *"
        // e.g. String.join(" ", ["4", "3", "5", "*", "+"]) -> "4 3 5 * +"
        return String.join(" ", postfix);
    }

    public static boolean isInteger(String symbol) {
        try {
            Integer.parseInt(symbol);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static int precedence(String opr) {
        return switch (opr) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
}
