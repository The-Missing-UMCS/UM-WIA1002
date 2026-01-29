package com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.strategy;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.domain.TowerOfHanoi;

public class BinaryHanoiStrategy implements HanoiStrategy {

    @Override
    public void execute(TowerOfHanoi towerOfHanoi) {
        int totalMoves = (int) Math.pow(2, towerOfHanoi.getNumOfDiscs()) - 1;
        int src, dst;

        for (int i = 1; i <= totalMoves; i++) {
            src = (i - (i & -i)) % 3;
            dst = (i + (i & -i)) % 3;
            towerOfHanoi.makeMove(src, dst);
        }
    }
}
