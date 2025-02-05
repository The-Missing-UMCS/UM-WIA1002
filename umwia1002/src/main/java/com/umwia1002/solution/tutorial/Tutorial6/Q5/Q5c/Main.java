package com.umwia1002.solution.tutorial.Tutorial6.Q5.Q5c;

import lombok.Getter;

import java.util.Stack;

public class Q5_PostfixToInfix {
    public static void main(String[] args) {
        String exp = "4 5 + 3 5 3 - / * ";
        String exp2 = "4 5 + 3 * 4 + 5 *";
        System.out.println(postfixToInfix(exp));
        System.out.println(postfixToInfix(exp2));
    }

    private static String postfixToInfix(String exp) {
        Stack<Expression> stack = new Stack<>();

        for (String ch : exp.trim().split("\\s+")) {
            if (isInteger(ch)) {
                stack.push(Expression.newOperand(ch));
            } else {
                stack.push(Expression.newOperation(stack.pop(), stack.pop(), ch));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop().getExpression();
    }

    private static boolean isInteger(String ch) {
        try {
            Integer.parseInt(ch);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static class Expression {
        @Getter
        private final String expression;
        private final String operator;
        private final int bracketLvl;

        private Expression(String operator, String expression, int bracketLvl) {
            this.operator = operator;
            this.expression = expression;
            this.bracketLvl = bracketLvl;
        }

        public static Expression newOperand(String ch) {
            return new Expression(null, ch, 0);
        }

        public static Expression newOperation(Expression right, Expression left, String operator) {
            String sb = String.format("%s %s %s",
                left.operator != null && precedence(operator) > precedence(left.operator)
                    ? bracket(left) : left.expression,
                operator,
                right.operator != null && precedence(operator) > precedence(right.operator)
                    ? bracket(right) : right.expression);

            int bracketLvl = Math.max(right.bracketLvl, left.bracketLvl) +
                (left.operator != null && precedence(operator) > precedence(left.operator) ||
                right.operator != null && precedence(operator) > precedence(right.operator)  ? 1 : 0);

            return new Expression(operator, sb, bracketLvl);
        }

        private static int precedence(String operator) {
            if (operator == null) return 0;
            return switch (operator) {
                case "+", "-" -> 1;
                case "*", "/" -> 2;
                default -> 0;
            };
        }

        private static String bracket(Expression exp) {
            String[] brackets = getBracket(exp.bracketLvl);
            return String.format("%s%s%s", brackets[0], exp.expression, brackets[1]);
        }

        private static String[] getBracket(int bracketLvl) {
            return switch (bracketLvl % 3) {
                case 1 -> new String[]{"[", "]"};
                case 2 -> new String[]{"{", "}"};
                default -> new String[]{"(", ")"};
            };
        }
    }
}


