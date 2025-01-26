package com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.util;

public class TextFormatter {
    /**
     * Formats the operator for the term.
     */
    public static String formatOperator(double coefficient, boolean isFirstTerm) {
        if (isFirstTerm) return "";
        return "%s ".formatted(coefficient > 0 ? "+" : "-");
    }

    /**
     * Formats the variable and its exponent.
     */
    public static String formatVariable(int degree) {
        if (degree == 0) return "";
        if (degree == 1) return "x";
        return "x^%d".formatted(degree);
    }

    public static String formatCoefficient(double coefficient, boolean isFirstTerm) {
        return formatValue(coefficient, isFirstTerm);
    }

    public static String formatValue(double value, boolean isFirstTerm) {
        return "%.2f".formatted(isFirstTerm ? value : Math.abs(value));
    }
}
