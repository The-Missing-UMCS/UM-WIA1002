package com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.service;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.domain.TowerOfHanoi;
import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.strategy.HanoiStrategy;
import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util.Util;


public class AutoService extends GameService {

    public AutoService(TowerOfHanoi towerOfHanoi, HanoiStrategy hanoiStrategy) {
        super(towerOfHanoi, hanoiStrategy);
    }

    @Override
    public void play() {
        towerOfHanoi.visualize();
        Util.doStepwise();
        hanoiStrategy.execute(towerOfHanoi);
        System.out.println();
    }
}
