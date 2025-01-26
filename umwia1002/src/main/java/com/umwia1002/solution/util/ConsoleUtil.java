package com.umwia1002.solution.util;

import org.jline.jansi.Ansi;

import static org.jline.jansi.Ansi.ansi;

public class ConsoleUtil {
    public static final Ansi.Color RED = Ansi.Color.RED;
    public static final Ansi.Color GREEN = Ansi.Color.GREEN;
    public static final Ansi.Color YELLOW = Ansi.Color.YELLOW;

    public static void logInfo(String message) {
        logBlue(message);
    }

    public static void logError(String message) {
        logRed(message);
    }

    public static void logBlue(String message) {
        System.out.println(ansi().fg(Ansi.Color.BLUE).a(message).reset());
    }

    public static void logYellow(String message) {
        System.out.println(ansi().fg(YELLOW).a(message).reset());
    }

    public static void logGreen(String message) {
        System.out.println(ansi().fg(GREEN).a(message).reset());
    }

    public static void logRed(String message) {
        System.out.println(ansi().fg(RED).a(message).reset());
    }

    public static void logWithColor(Ansi.Color color, String message) {
        System.out.println(ansi().fg(color).bold().a(message).reset());
    }
}
