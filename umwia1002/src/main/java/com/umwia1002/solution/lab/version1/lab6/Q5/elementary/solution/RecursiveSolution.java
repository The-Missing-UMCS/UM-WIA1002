package com.umwia1002.solution.lab.version1.lab6.Q5.elementary.solution;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util.Util;
import com.umwia1002.solution.lab.version1.lab6.Q5.elementary.IntStack;

public class RecursiveSolution extends HanoiSolution {

    public RecursiveSolution(int numOfDisc) {
        super(numOfDisc);
    }

    @Override
    public void solve() {
        hanoi(numOfDisc, 0, 2, 1);
    }

    private void hanoi(int disc, int src, int dst, int mid) {
        if (disc > 0) {
            hanoi(disc - 1, src, mid, dst);
            makeMove(towers[src], towers[dst]);
            visualize();
            Util.delay();
            hanoi(disc - 1, mid, dst, src);
        }
    }

    private void makeMove(IntStack src, IntStack dst) {
        dst.push(src.pop());
    }

}
