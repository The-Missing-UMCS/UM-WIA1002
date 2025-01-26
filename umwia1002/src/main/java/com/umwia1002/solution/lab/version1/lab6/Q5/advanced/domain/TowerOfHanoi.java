package com.umwia1002.solution.lab.version1.lab6.Q5.advanced.domain;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util.ToHPrinter;

import java.util.Stack;

public interface TowerOfHanoi {
    ToHPrinter TOH_PRINTER = new ToHPrinter();

    int peek(int rod);

    int makeMove(int src, int dst);

    boolean isValidMove(int src, int dst);

    boolean isFinished();

    int getNumOfDiscs();

    Stack<Integer>[] getStacks();

    default void visualize() {
        TOH_PRINTER.printTower(getNumOfDiscs(), getStacks());
    }
}
