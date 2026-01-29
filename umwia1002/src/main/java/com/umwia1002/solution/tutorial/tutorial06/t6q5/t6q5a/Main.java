package com.umwia1002.solution.tutorial.tutorial06.t6q5.t6q5a;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String exp = "4 5 + 3 5 3 - / * ";
        String exp2 = "4 5 + 3 * 4 + 5 *";
        System.out.println(postfixToInfix(exp));
        System.out.println(postfixToInfix(exp2));
    }

    private static String postfixToInfix(String exp) {
        Stack<Node> expressions = new Stack<>();

        for (String ch : exp.trim().split("\\s+")) {
            if (isInteger(ch)) {
                expressions.push(new Node(ch));
            } else {
                if (expressions.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                Node right = expressions.pop();
                Node left = expressions.pop();
                expressions.push(new Node(ch, left, right));
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

    @AllArgsConstructor
    @RequiredArgsConstructor
    static class Node {

        private final String val;
        private Node left;
        private Node right;

        private static int precedence(String val) {
            return switch (val) {
                case "+", "-" -> 1;
                case "*", "/", "%" -> 2;
                default -> 0;
            };
        }

        @Override
        public String toString() {
            String leftExp = left == null
                             ? ""
                             : left.isOperator() && precedence(val) > precedence(left.val)
                               ? String.format("(%s)", left)
                               : left.toString();

            String rightExp = right == null
                              ? ""
                              : right.isOperator() && precedence(val) > precedence(right.val)
                                ? String.format("(%s)", right)
                                : right.toString();

            return String.format("%s%s%s", leftExp, val, rightExp);
        }

        private boolean isOperator() {
            return left != null && right != null;
        }
    }
}
