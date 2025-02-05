package com.umwia1002.solution.lab.version2.lab5.Q2;

import com.umwia1002.solution.util.TimerUtil;

import java.io.File;
import java.util.*;

import static com.umwia1002.solution.util.FileUtil.*;

public class Main {
    public static void main(String[] args) throws Exception {
        final String file = chain(LAB_V2_LAB5, IO_FILES, "question.txt");
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                // a.
                String infixExpression = sc.nextLine().trim();
                if (infixExpression.isEmpty()) {
                    System.out.println("Empty expression encountered.");
                    continue;
                }
                System.out.printf("The infix expression is: %s%n", infixExpression);

                // b.
                String[] infixTokens = tokenizeInfixExpression(infixExpression);
                System.out.printf("The infix tokens are: %s%n", String.join(" ", infixTokens));

                // c.
                String[] postfixTokens = infixToPostfix(infixTokens);
                System.out.printf("The postfix expression is : %s%n", String.join(" ", postfixTokens));

                // d.
                try {
                    int result = evaluatePostfix(postfixTokens);
                    System.out.printf("The result is: %s%n%n", result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error evaluating postfix expression: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Tokenizes the given infix expression into an array of strings.
     *
     * @param expression The infix expression.
     * @return Array of tokens.
     */
    public static String[] tokenizeInfixExpression(String expression) {
        return Arrays.stream(expression.split("\\s+"))
            .map(token -> isNumeric(token) ? token : toSymbol(token))
            .toArray(String[]::new);
    }

    /**
     * Converts an infix expression to postfix notation.
     *
     * @param infixTokens Array of infix tokens.
     * @return Array of postfix tokens.
     */
    public static String[] infixToPostfix(String[] infixTokens) {
        List<String> postfix = new ArrayList<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for (String token : infixTokens) {
            if (isNumeric(token)) {
                postfix.add(token);
            } else if ("(".equals(token)) {
                operatorStack.push(token);
            } else if (")".equals(token)) {
                while (!operatorStack.isEmpty() && !"(".equals(operatorStack.peek())) {
                    postfix.add(operatorStack.pop());
                }
                operatorStack.pop(); // Remove "(" from stack
            } else {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    postfix.add(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            if ("(".equals(operatorStack.peek())) {
                throw new IllegalArgumentException("Mismatched parentheses.");
            }
            postfix.add(operatorStack.pop());
        }

        return postfix.toArray(String[]::new);
    }

    /**
     * Evaluates a postfix expression.
     *
     * @param postfixTokens Array of postfix tokens.
     * @return Evaluation result.
     */
    public static int evaluatePostfix(String[] postfixTokens) {
        Deque<Integer> operandStack = new ArrayDeque<>();

        for (String token : postfixTokens) {
            if (isNumeric(token)) {
                operandStack.push(Integer.parseInt(token));
            } else {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression.");
                }
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = performOperation(operand1, operand2, token);
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    /**
     * Performs a mathematical operation on two operands.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @param operator The operator.
     * @return Result of the operation.
     */
    public static int performOperation(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) throw new ArithmeticException("Division by zero");
                yield operand1 / operand2;
            }
            case "%" -> operand1 % operand2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public static String toSymbol(String operator) {
        return switch (operator) {
            case "add" -> "+";
            case "sub" -> "-";
            case "mul" -> "*";
            case "div" -> "/";
            case "mod" -> "%";
            case "ob" -> "(";
            case "cb" -> ")";
            default -> " ";
        };
    }

    /**
     * Checks if a string is numeric.
     *
     * @param str The string to check.
     * @return True if numeric, false otherwise.
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Determines the precedence of an operator.
     *
     * @param operator The operator.
     * @return Precedence value.
     */
    public static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/", "%" -> 2;
            default -> 0;
        };
    }
}
