package com.umwia1002.solution.lab.version1.lab06.l6q5.elementary.solution;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util.Util;
import com.umwia1002.solution.lab.version1.lab06.l6q5.elementary.IntStack;

public class IterativeSolution extends HanoiSolution {

    public IterativeSolution(int numOfDisc) {
        super(numOfDisc);
    }

    @Override
    public void solve() {
        int[][] odd = {{0, 2}, {0, 1}, {1, 2}};
        int[][] even = {{0, 1}, {0, 2}, {1, 2}};
        int[][] move = (numOfDisc % 2 == 0) ? even : odd;

        IntStack dst = towers[2];

        while (!isFinished(dst, numOfDisc)) {
            for (int[] loc : move) {
                makeMove(towers[loc[0]], towers[loc[1]]);
                visualize();

                if (isFinished(dst, numOfDisc)) {
                    break;
                }

                Util.delay();
            }
        }
    }

    public static void makeMove(IntStack src, IntStack dst) {
        if (isValidMove(src, dst)) {
            dst.push(src.pop());
        } else {
            src.push(dst.pop());
        }
    }

    public static boolean isValidMove(IntStack src, IntStack dst) {
        return !src.isEmpty() && (dst.isEmpty() || src.peek() < dst.peek());
    }

    public static boolean isFinished(IntStack dst, int numOfDisc) {
        return dst.size() == numOfDisc;
    }
}
