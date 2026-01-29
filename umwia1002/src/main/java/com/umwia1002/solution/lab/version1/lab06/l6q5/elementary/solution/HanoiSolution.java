package com.umwia1002.solution.lab.version1.lab06.l6q5.elementary.solution;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util.ToHPrinter;
import com.umwia1002.solution.lab.version1.lab06.l6q5.elementary.IntStack;

import java.util.Arrays;
import java.util.Stack;

public abstract class HanoiSolution {

    private static final ToHPrinter TOH_PRINTER = new ToHPrinter();

    protected final IntStack[] towers;
    protected final int numOfDisc;

    public HanoiSolution(int numOfDisc) {
        this.numOfDisc = numOfDisc;
        this.towers = new IntStack[3];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < towers.length; i++) {
            towers[i] = new IntStack();
        }

        for (int i = numOfDisc; i > 0; i--) {
            towers[0].push(i);
        }
    }

    @SuppressWarnings("unchecked")
    public void visualize() {
        Stack<Integer>[] stacks = Arrays.stream(towers).map(IntStack::stacks).toArray(Stack[]::new);
        TOH_PRINTER.printTower(numOfDisc, stacks);
    }

    public abstract void solve();
}
