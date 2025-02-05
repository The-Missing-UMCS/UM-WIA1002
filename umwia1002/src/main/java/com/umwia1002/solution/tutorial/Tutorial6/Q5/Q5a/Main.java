package com.umwia1002.solution.tutorial.Tutorial6.Q5.Q5b;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String exp = "4 5 + 3 5 3 - / * ";
        String exp2 = "4 5 + 3 * 4 + 5 *";
        System.out.println(postfixToInfix(exp));
        System.out.println(postfixToInfix(exp2));
    }

    private static String postfixToInfix(String exp) {
        Stack<ExpNode> expressions = new Stack<>();

        for (String ch : exp.trim().split("\\s+")) {
            if (isInteger(ch)) {
                expressions.push(new ExpNode(ch));
            } else {
                if (expressions.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                ExpNode right = expressions.pop();
                ExpNode left = expressions.pop();
                expressions.push(new ExpNode(ch, left, right));
            }
        }

        if (expressions.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
        return expressions.pop().toString();
    }

    private static boolean isInteger(String ch) {
        try {
            Integer.parseInt(ch);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
