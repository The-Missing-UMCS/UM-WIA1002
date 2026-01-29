package com.umwia1002.solution.tutorial.tutorial06.t6q6;

import java.util.Stack;

public class Q6 {

    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'C', 'B');
        System.out.println(factorial(5));
        System.out.println(infixToPostfix("( 4 + 3 ) * 5"));
    }

    public static int factorial(int i) {
        if (i == 1 || i == 0) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    public static void towerOfHanoi(int disc, char src, char dst, char aux) {
        if (disc == 1) {
            System.out.printf("Disc %d: %c --> %c\n", disc, src, dst);
        } else {
            towerOfHanoi(disc - 1, src, aux, dst);
            System.out.printf("Disc %d: %c --> %c\n", disc, src, dst);
            towerOfHanoi(disc - 1, aux, dst, src);
        }
    }

    private static String infixToPostfix(String exp) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (String ch : exp.trim().split("\\s+")) {
            if (isInteger(ch)) {
                postfix.append(ch).append(" ");
            } else {
                if ("(".equals(ch)) {
                    stack.push(ch);
                } else if (")".equals(ch)) {
                    while (!"(".equals(stack.peek())) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString();
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
}
