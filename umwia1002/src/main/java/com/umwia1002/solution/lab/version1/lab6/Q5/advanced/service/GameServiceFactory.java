package com.umwia1002.solution.lab.version1.lab6.Q5.advanced.service;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.domain.TowerOfHanoi;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.domain.TowerOfHanoiImpl;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.domain.TowerOfHanoiProxy;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.strategy.BinaryHanoiStrategy;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.strategy.HanoiStrategy;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.strategy.IterativeHanoiStrategy;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.strategy.RecursiveHanoiStrategy;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util.GlobalTracer;
import org.apache.commons.lang3.Validate;

import java.util.Map;

public class GameServiceFactory {
    public static final int MANUAL = 1;
    public static final int BINARY = 2;
    public static final int ITERATIVE = 3;
    public static final int RECURSIVE = 4;

    private static final Map<Integer, HanoiStrategy> STRATEGY_MAP = Map.of(
        BINARY, new BinaryHanoiStrategy(),
        ITERATIVE, new IterativeHanoiStrategy(),
        RECURSIVE, new RecursiveHanoiStrategy()
    );

    public static GameService getGameServiceByCode(int code) {
        TowerOfHanoi towerOfHanoi = getTowerOfHanoiByCode(code);
        if (code == MANUAL) {
            return ManualService.getInstance(towerOfHanoi);
        }
        HanoiStrategy hanoiStrategy = STRATEGY_MAP.get(code);
        Validate.notNull(hanoiStrategy, "Invalid choice: " + code);
        return new AutoService(towerOfHanoi, hanoiStrategy);
    }

    private static TowerOfHanoi getTowerOfHanoiByCode(int code) {
        if (code == MANUAL) {
            return new TowerOfHanoiImpl();
        }
        return new TowerOfHanoiProxy(new TowerOfHanoiImpl(), GlobalTracer.isIsStepwiseModeOn(), GlobalTracer.isIsCommentModeOn());
    }
}
