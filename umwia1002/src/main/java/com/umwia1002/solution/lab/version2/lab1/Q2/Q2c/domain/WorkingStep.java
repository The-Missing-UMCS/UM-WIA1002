package com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.domain;

public interface WorkingStep {
    String initialExpression();

    String afterSubstitution();

    String afterSimplification();

    String afterEvaluation();

    double substitute();

    double[] coefficients();

    double result();

    default String expression() {
        final String format = "  = %s ";
        return String.join(System.lineSeparator(),
            String.format(format, initialExpression()),
            String.format(format, afterSubstitution()),
            String.format(format, afterSimplification()),
            String.format(format, result()));
    }
}
