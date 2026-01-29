package com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.service;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.domain.TowerOfHanoi;
import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.strategy.HanoiStrategy;
import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util.ToHPrinter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class GameService {

    protected static final ToHPrinter TOH_PRINTER = new ToHPrinter();
    private static final int DELAY = 1500;

    protected final TowerOfHanoi towerOfHanoi;
    protected final HanoiStrategy hanoiStrategy;

    protected void delay() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException _) {
        }
    }

    public abstract void play();
}
