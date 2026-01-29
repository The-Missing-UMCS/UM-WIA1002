package com.umwia1002.solution.lab.version2.lab01.l1q2.l1q2c.domain;

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
            String.format(format, result())
        );
    }
}
