package com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.service;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.domain.TowerOfHanoi;
import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.domain.TowerOfHanoiImpl;
import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.strategy.HanoiStrategy;
import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.strategy.ManualHanoiStrategy;
import com.umwia1002.solution.util.InputUtil;


public class ManualService extends GameService {

    private static final String ROD_LABELS = TowerOfHanoiImpl.ROD_LABELS;

    private ManualService(TowerOfHanoi towerOfHanoi, HanoiStrategy hanoiStrategy) {
        super(towerOfHanoi, hanoiStrategy);
    }

    public static ManualService getInstance(TowerOfHanoi towerOfHanoi) {

        return new ManualService(towerOfHanoi, new ManualHanoiStrategy());
    }

    @Override
    public void play() {
        towerOfHanoi.visualize();

        while (!towerOfHanoi.isFinished()) {
            String input = InputUtil.getValidatedInput(
                "Enter the move (e.g: a c): ", InputUtil.scannerNextLine(),
                this::isValidCommand, "Invalid command.");

            int src = ROD_LABELS.indexOf(input.charAt(0));
            int dst = ROD_LABELS.indexOf(input.charAt(2));

            if (towerOfHanoi.isValidMove(src, dst)) {
                towerOfHanoi.makeMove(src, dst);
                towerOfHanoi.visualize();
            } else {
                System.out.printf("Invalid move: %s. %d at %c is larger than %d at %c%n%n", input,
                    towerOfHanoi.peek(src), (char) (src + 'a'),
                    towerOfHanoi.peek(dst), (char) (dst + 'a'));
            }
        }

        System.out.println("Well done!%n");
        delay();
    }

    private boolean isValidCommand(String input) {
        return input.length() == 3 && isWithinRange(input.charAt(0)) && isWithinRange(
            input.charAt(2));
    }

    private boolean isWithinRange(char move) {
        return ROD_LABELS.indexOf(move) >= 0 && ROD_LABELS.indexOf(move) <= 2;
    }
}
