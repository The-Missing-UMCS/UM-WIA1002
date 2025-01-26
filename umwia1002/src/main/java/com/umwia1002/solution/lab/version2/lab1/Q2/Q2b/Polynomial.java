package com.umwia1002.solution.lab.version2.lab1.Q2.Q2b;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Getter
@RequiredArgsConstructor
public class Polynomial {
    private final int degree;
    private final double[] coefficients;

    public static Polynomial of(int degree, double... coefficients) {
        if (coefficients.length != degree + 1) {
            throw new IllegalArgumentException("Invalid number of coefficients");
        }
        return new Polynomial(degree, coefficients);
    }

    /**
     * Formats the operator for the term.
     */
    private static String formatOperator(double coefficient, boolean isFirstTerm) {
        if (isFirstTerm) return "";
        return coefficient > 0 ? "+" : "-";
    }

    /**
     * Formats the variable and its exponent.
     */
    private static String formatVariable(int degree) {
        if (degree == 0) return "";
        if (degree == 1) return "x";
        return "x^" + degree;
    }

    private static String formatValue(double value, boolean isFirstTerm) {
        return String.format("%.2f", isFirstTerm ? value : Math.abs(value));
    }

    /**
     * Generates the string representation of the polynomial.
     */
    @Override
    public String toString() {
        return IntStream.range(0, coefficients.length)
            .mapToObj(i -> {
                int deg = degree - i;
                double coefficient = coefficients[i];

                if (coefficient == 0) {
                    return ""; // Skip zero coefficients
                }

                return String.format("%s%s%s",
                    formatOperator(coefficient, i == 0),
                    formatValue(coefficient, i == 0),
                    formatVariable(deg));
            })
            .filter(term -> !term.isBlank())
            .collect(Collectors.joining(" "));
    }

    /**
     * Calculates the value of the polynomial using Horner's method.
     * Returns a `WorkingStep` object for step-by-step details.
     */
    public WorkingStep calculate(double x) {
        double result = 0;
        for (double coefficient : coefficients) {
            result = result * x + coefficient;
        }
        return new WorkingStep(toString(), x, degree, coefficients, result);
    }

    /**
     * Nested Record to represent the step-by-step solution for polynomial evaluation.
     */
    public record WorkingStep(String expression, double substitute, int degree, double[] coefficients, double result) {
        /**
         * Returns the initial polynomial expression.
         */
        public String initialExpression() {
            return expression;
        }

        /**
         * Returns the polynomial after substituting the value of x.
         */
        public String afterSubstitution() {
            return expression.replace("x", String.format("(%.2f)", substitute));
        }

        /**
         * Returns the simplified polynomial expression.
         */
        public String afterSimplification() {
            return IntStream.range(0, coefficients.length)
                .mapToObj(i -> {
                    double coefficient = coefficients[i];
                    int deg = degree - i;

                    if (coefficient == 0) return "";

                    boolean isFirstTerm = i == 0;
                    double value = coefficient * Math.pow(substitute, deg);
                    return String.format("%s%s",
                        formatOperator(value, isFirstTerm),
                        formatValue(value, isFirstTerm));
                })
                .filter(term -> !term.isBlank())
                .collect(Collectors.joining(" "));
        }

        /**
         * Returns the final evaluation result of the polynomial.
         */
        public String afterEvaluation() {
            return String.format("%s = %.2f", afterSimplification(), result);
        }

        @Override
        public String toString() {
            final String format = "  = %s";
            return String.join(System.lineSeparator(),
                String.format(format, initialExpression()),
                String.format(format, afterSubstitution()),
                String.format(format, afterSimplification()),
                String.format(format, result)
            );
        }
    }
}
