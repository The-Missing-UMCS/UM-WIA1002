package com.umwia1002.solution.lab.version2.lab05.l5q3;

import java.util.Stack;

public class l5q3c {

    public static int count = 0;

    public static void main(String[] args) {
        solveNQueen(4);
    }

    private static void solveNQueen(int N) {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Solving the " + N + " Queens problem");
        solveNQueen(stack, N, 0, 0);
        System.out.println("The number of solutions is " + count);
    }

    private static void solveNQueen(Stack<Integer> stack, int N, int row, int col) {
        if (row >= 0) {
            if (stack.size() == N) {
                printSolution(stack);
                count++;
                solveNQueen(stack, N, --row, stack.pop() + 1);
            } else {
                while (col < N) {
                    if (isSafe(stack, col)) {
                        stack.push(col);
                        break;
                    }
                    col++;
                }

                if (col < N) {
                    solveNQueen(stack, N, ++row, 0);
                } else {
                    if (!stack.empty()) {
                        solveNQueen(stack, N, --row, stack.pop() + 1);
                    }
                }
            }
        }
    }

    private static boolean isSafe(Stack<Integer> stack, int col) {
        int row = stack.size();
        for (int i = 0; i < row; i++) {
            int tmp = stack.get(i);
            if (tmp == col || Math.abs(tmp - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution(Stack<Integer> stack) {
        int N = stack.size();
        for (Integer integer : stack) {
            for (int j = 0; j < N; j++) {
                if (j == integer) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
