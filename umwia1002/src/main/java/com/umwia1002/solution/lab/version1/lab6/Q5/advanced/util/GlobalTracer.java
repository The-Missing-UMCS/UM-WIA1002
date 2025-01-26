package com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util;

public class GlobalTracer {
    private static boolean isStepwiseModeOn = false;
    private static boolean isCommentModeOn = false;
    private static long delay = 1500;

    public static boolean isIsStepwiseModeOn() {
        return isStepwiseModeOn;
    }

    public static void setIsStepwiseModeOn(boolean isStepwiseModeOn) {
        GlobalTracer.isStepwiseModeOn = isStepwiseModeOn;
    }

    public static void toggleStepwiseMode() {
        isStepwiseModeOn = !isStepwiseModeOn;
    }

    public static boolean isIsCommentModeOn() {
        return isCommentModeOn;
    }

    public static void setIsCommentModeOn(boolean isCommentModeOn) {
        GlobalTracer.isCommentModeOn = isCommentModeOn;
    }

    public static void toggleCommentMode() {
        isCommentModeOn = !isCommentModeOn;
    }

    public static long getDelay() {
        return delay;
    }

    public static void setDelay(long delay) {
        GlobalTracer.delay = delay;
    }
}
