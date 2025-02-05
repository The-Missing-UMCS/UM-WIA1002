package com.umwia1002.solution.tutorial.Tutorial6.Q3;

import java.util.Iterator;
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

                if (stack.isEmpty())
                    break Outer;

                if (!hasValidMove)
                    step = backtrack(stack, tokens);
                else
                    step = 0;
            }

            printStack(stack);
            step = backtrack(stack, tokens);
        }
    }

    private static void findAllPossibleSequences(int[] sequences) {

    }

    public static void performMove(int step, Stack<Integer> stack, int[] tokens) {
        if (MOVE[step] == PUSH) {
            // If current move is PUSH
            tokens[0]--;
            tokens[1]++;
        } else {
            // If the current move is POP
            tokens[1]--;
        }
        stack.push(step);
    }

    public static int backtrack(Stack<Integer> stack, int[] tokens) {
        int prev = stack.pop();
        if (MOVE[prev]) {
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
        Stack<Integer> stack_int = new Stack<Integer>();
        StringBuilder intBuilder = new StringBuilder();
        StringBuilder stepBuilder = new StringBuilder();

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            if (MOVE[iterator.next()]) {
                stack_int.push(++token);
                stepBuilder.append("Push " + token + " ");
            } else {
                int val = stack_int.pop();
                intBuilder.append(val + " ");
                stepBuilder.append("Pop " + val + " ");
            }
        }

        System.out.println(stepBuilder);
        System.out.println(intBuilder);
        System.out.println();
    }
}
