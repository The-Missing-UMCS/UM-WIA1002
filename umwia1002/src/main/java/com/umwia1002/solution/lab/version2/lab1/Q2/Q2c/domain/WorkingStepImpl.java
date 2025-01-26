package com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.domain;

import com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.util.TextFormatter;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record WorkingStepImpl(
    String expression,
    double substitute,
    int degree,
    double[] coefficients,
    double result)
    implements WorkingStep {

    @Override
    public String initialExpression() {
        return expression;
    }

    @Override
    public String afterSubstitution() {
        return expression.replace("x", "(%.2f)".formatted(substitute));
    }

    @Override
    public String afterSimplification() {
        return IntStream.range(0, coefficients.length)
            .mapToObj(i -> formatTerm(coefficients[i], degree - i, i == 0))
            .filter(term -> !term.isBlank())
            .collect(Collectors.joining(" "));
    }

    private String formatTerm(double coefficient, int deg, boolean isFirstTerm) {
        if (coefficient == 0) return "";
        double value = coefficient * Math.pow(substitute, deg);
        return String.format(
            "%s%s",
            TextFormatter.formatOperator(value, isFirstTerm),
            TextFormatter.formatValue(value, isFirstTerm)
        );
    }

    @Override
    public String afterEvaluation() {
        return "%s = %.2f".formatted(afterSimplification(), result);
    }

    @Override
    public String toString() {
        return expression();
    }
}
