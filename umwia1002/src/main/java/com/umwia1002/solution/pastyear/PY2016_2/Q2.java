package com.umwia1002.solution.pastyear.PY2016_2;

import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        String line = "System.out.println(\"Hello World!\");";
        if (isMatched(line))
            System.out.println("YES - all matched!");
        else
            System.out.println("Not all bracket are matched.");
    }

    public static boolean isMatched(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isCloseBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), ch)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean isMatchingPair(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')') ||
                (openBracket == '[' && closeBracket == ']') ||
                (openBracket == '{' && closeBracket == '}');
    }
}
