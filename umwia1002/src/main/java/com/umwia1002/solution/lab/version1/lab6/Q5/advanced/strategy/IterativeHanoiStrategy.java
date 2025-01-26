package com.umwia1002.solution.lab.version1.lab6.Q5.advanced.strategy;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.domain.TowerOfHanoi;

public class IterativeHanoiStrategy implements HanoiStrategy {
    @Override
    public void execute(TowerOfHanoi towerOfHanoi) {
        int numOfDiscs = towerOfHanoi.getNumOfDiscs();
        int totalMoves = (int) Math.pow(2, numOfDiscs) - 1;
        int[][] odd = {{1, 2}, {0, 2}, {0, 1}};
        int[][] even = {{1, 2}, {0, 1}, {0, 2}};
        int[][] moves = (numOfDiscs % 2 == 1 ? odd : even);

        for (int i = 1; i <= totalMoves; i++) {
            int move = i % 3;
            int src = moves[move][0], dst = moves[move][1];
            makeMove(towerOfHanoi, src, dst);
        }
    }

    private void makeMove(TowerOfHanoi towerOfHanoi, int src, int dst) {
        if (towerOfHanoi.isValidMove(src, dst)) {
            towerOfHanoi.makeMove(src, dst);
        } else {
            towerOfHanoi.makeMove(dst, src);
        }
    }
}

