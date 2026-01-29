package com.umwia1002.solution.util;

public class TimerUtil {

    public static void delay() {
        delay(1000);
    }

    public static void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
