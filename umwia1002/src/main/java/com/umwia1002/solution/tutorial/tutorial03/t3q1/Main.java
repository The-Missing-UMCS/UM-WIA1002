package com.umwia1002.solution.tutorial.tutorial03.t3q1;

import com.umwia1002.solution.tutorial.tutorial03.t3q1.impl.CandyMachine;
import com.umwia1002.solution.tutorial.tutorial03.t3q1.impl.Dispenser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CandyMachine machine = CandyMachine.getInstance(List.of(Dispenser.values()), 100.0);
        machine.operate();
    }
}
