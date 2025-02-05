package com.umwia1002.solution.tutorial.Tutorial6.Q3;

import java.util.Stack;

public class GivenSequence {
    public static void main(String[] args) {
        System.out.println(solveSequence(new int[]{1, 2, 3}, new int[]{1, 3, 2}));
    }

    public static String solveSequence(int[] pushSequence, int[] popSequence) {
        int pPush = 0, pPop = 0, size = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        StringBuilder stepBuilder = new StringBuilder();

        while (pPush < size || !stack.isEmpty()) {
            // 1. Check if we can pop the stack to match the pop sequence
            if (!stack.empty() && popSequence[pPop] == stack.peek()) {
                stepBuilder.append("Pop %d ".formatted(stack.pop()));
                pPop++;
            } else {
                // If we have pushed all the elements, but we cannot pop the stack to match the pop sequence
                // then the sequence is invalid
                if (pPush == size) {
                    return "No solution";
                }
                stack.push(pushSequence[pPush]);
                stepBuilder.append("Push %d ".formatted(pushSequence[pPush]));
                pPush++;
            }
        }

        return stepBuilder.toString();
    }
}
