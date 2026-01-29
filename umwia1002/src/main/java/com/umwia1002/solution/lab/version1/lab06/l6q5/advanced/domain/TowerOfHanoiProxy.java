package com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.domain;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util.Util;
import lombok.RequiredArgsConstructor;

import java.util.Stack;

@RequiredArgsConstructor
public class TowerOfHanoiProxy implements TowerOfHanoi {

    private final TowerOfHanoiImpl towerOfHanoi;
    private final boolean isStepwise;
    private final boolean isComment;

    @Override
    public int peek(int rod) {
        return towerOfHanoi.peek(rod);
    }

    @Override
    public int makeMove(int src, int dst) {
        // 1. Get the disc moved
        int discMoved = towerOfHanoi.makeMove(src, dst);

        // 2. Add post .makeMove() logic
        towerOfHanoi.visualize();
        doComment(discMoved, src, dst);
        Util.doStepwise();

        // 3. Return the disc moved
        return discMoved;
    }

    @Override
    public boolean isValidMove(int src, int dst) {
        return towerOfHanoi.isValidMove(src, dst);
    }

    @Override
    public boolean isFinished() {
        return towerOfHanoi.isFinished();
    }

    @Override
    public int getNumOfDiscs() {
        return towerOfHanoi.getNumOfDiscs();
    }

    @Override
    public Stack<Integer>[] getStacks() {
        return towerOfHanoi.getStacks();
    }

    private void doComment(int disc, int src, int dst) {
        if (isComment) {
            System.out.printf("%s%d : %s --> %s%n",
                " ".repeat(towerOfHanoi.getNumOfDiscs()), disc,
                TowerOfHanoiImpl.ROD_LABELS.charAt(src), TowerOfHanoiImpl.ROD_LABELS.charAt(dst));
        }
    }
}
