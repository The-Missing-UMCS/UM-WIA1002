package com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.strategy;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.domain.TowerOfHanoi;

public class RecursiveHanoiStrategy implements HanoiStrategy {

    @Override
    public void execute(TowerOfHanoi towerOfHanoi) {
        solve(towerOfHanoi.getNumOfDiscs(), 0, 2, 1, towerOfHanoi);
    }

    private void solve(int n, int src, int dst, int aux, TowerOfHanoi towerOfHanoi) {
        if (n == 0) {
            return;
        }

        solve(n - 1, src, aux, dst, towerOfHanoi);
        towerOfHanoi.makeMove(src, dst);
        solve(n - 1, aux, dst, src, towerOfHanoi);
    }
}
