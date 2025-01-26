package com.umwia1002.solution.lab.version2.lab1.Q2.Q2a;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Polynomial(int degree, double[] coefficients) {

    /**
     * Formats the operator based on the coefficient.
     */
    private static String formatOperator(double coefficient, boolean isFirstTerm) {
        if (coefficient > 0 && !isFirstTerm) {
            return "+";
        } else if (coefficient < 0) {
            return "-";
        }
        return "";
    }

    /**
     * Formats the variable and its exponent.
     */
    private static String formatVariable(int degree) {
        if (degree == 0) {
            return "";
        } else if (degree == 1) {
            return "x";
        } else {
            return "x^" + degree;
        }
    }


    @Override
    public String toString() {
        // Build the polynomial string using streams
        return IntStream.range(0, coefficients.length)
            .mapToObj(i -> {
                int deg = degree - i;
                double coefficient = coefficients[i];
                boolean isFirstTerm = i == 0;

                // Skip zero coefficients
                if (coefficient == 0) {
                    return "";
                }

                return String.format("%s %.2f%s",
                    formatOperator(coefficient, isFirstTerm),
                    Math.abs(coefficient),
                    formatVariable(deg));
            })
            .filter(term -> !term.isBlank()) // Remove empty terms
            .collect(Collectors.joining(" "));
    }

    /**
     * Calculates the value of the polynomial using Horner's method.
     */
    public double calculate(double x) {
        double result = 0;
        for (double coefficient : coefficients) {
            result = result * x + coefficient;
        }
        return result;
    }

    /**
     * Formats the polynomial and its value at x as a string.
     */
    public String calculateAsString(double x) {
        return String.format("%s = %.2f%n", substitute(x), calculate(x));
    }

    private String substitute(double x) {
        return toString().replace("x", String.format("(%s)".formatted(x)));
    }
}
