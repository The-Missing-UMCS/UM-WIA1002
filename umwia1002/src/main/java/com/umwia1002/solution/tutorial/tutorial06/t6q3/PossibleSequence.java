package com.umwia1002.solution.tutorial.tutorial06.t6q3;

import java.util.Stack;

public class PossibleSequence {

    public static final boolean PUSH = true;
    public static final boolean POP = false;

    public static final boolean[] MOVE = {PUSH, POP};
    // true = push, false = pop
    // tokens[0] is push_token, tokens[1] = pop_token;

    public static void main(String[] args) {
        int[] tokens = {3, 0};
        int step = 0;
        Stack<Integer> stack = new Stack<>();

        Outer:
        while (true) {
            while (canPerformMoves(tokens)) {
                boolean hasValidMove = false;

                for (; step < 2 && !hasValidMove; step++) {
                    if (isValidMove(tokens, MOVE[step])) {
                        performMove(step, stack, tokens);
                        hasValidMove = true;
                    }
                }

                if (stack.isEmpty()) {
                    break Outer;
                }

                if (!hasValidMove) {
                    step = backtrack(stack, tokens);
                } else {
                    step = 0;
                }
            }

            printStack(stack);
            step = backtrack(stack, tokens);
        }
    }

    public static void performMove(int step, Stack<Integer> stack, int[] tokens) {
        if (MOVE[step] == PUSH) {
            tokens[0]--;
            tokens[1]++;
        } else {
            tokens[1]--;
        }
        stack.push(step);
    }

    public static int backtrack(Stack<Integer> stack, int[] tokens) {
        int prev = stack.pop();
        if (MOVE[prev] == PUSH) {
            tokens[0]++;
            tokens[1]--;
        } else {
            tokens[1]++;
        }
        return prev + 1;
    }

    public static boolean isValidMove(int[] tokens, boolean move) {
        return (move == PUSH && tokens[0] > 0) || (move == POP && tokens[1] > 0);
    }

    public static boolean canPerformMoves(int[] tokens) {
        return tokens[0] > 0 || tokens[1] > 0;
    }

    public static void printStack(Stack<Integer> stack) {
        int token = 0;
        Stack<Integer> intStack = new Stack<>();
        StringBuilder intBuilder = new StringBuilder();
        StringBuilder stepBuilder = new StringBuilder();

        for (Integer integer : stack) {
            if (MOVE[integer] == PUSH) {
                intStack.push(++token);
                stepBuilder.append("Push ").append(token).append(" ");
            } else {
                int val = intStack.pop();
                intBuilder.append(val).append(" ");
                stepBuilder.append("Pop ").append(val).append(" ");
            }
        }

        System.out.println(stepBuilder);
        System.out.println(intBuilder);
        System.out.println();
    }
}
