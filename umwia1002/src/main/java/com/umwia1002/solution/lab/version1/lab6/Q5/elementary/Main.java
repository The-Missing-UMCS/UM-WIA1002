package com.umwia1002.solution.lab.version1.lab6.Q5.elementary;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util.Util;
import com.umwia1002.solution.lab.version1.lab6.Q5.elementary.solution.HanoiSolution;
import com.umwia1002.solution.lab.version1.lab6.Q5.elementary.solution.IterativeSolution;
import com.umwia1002.solution.lab.version1.lab6.Q5.elementary.solution.RecursiveSolution;
import com.umwia1002.solution.util.InputUtil;

public class Main {
    public static void main(String[] args) {
        int numOfDisc = InputUtil.getIntInput("Enter the number of disc(s): ");

        HanoiSolution[] solutions = {new IterativeSolution(numOfDisc), new RecursiveSolution(numOfDisc)};
        int choice = 1;

        solutions[choice].visualize();
        Util.delay();
        solutions[choice].solve();
    }
}
