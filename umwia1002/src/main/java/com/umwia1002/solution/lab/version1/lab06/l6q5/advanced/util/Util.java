package com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util;

import com.umwia1002.solution.util.InputUtil;

public class Util {

    public static void doStepwise() {
        if (GlobalTracer.isIsStepwiseModeOn()) {
            InputUtil.getStringInput("Press any key to continue...");
        } else {
            delay();
        }
    }

    public static void delay() {
        delay(GlobalTracer.getDelay());
    }

    public static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
