package com.umwia1002.solution.lab.version2.lab01.l1q2.l1q2c.domain;

import com.umwia1002.solution.lab.version2.lab01.l1q2.l1q2c.util.TextFormatter;
import lombok.Getter;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Getter
public class Polynomial {

    private final int degree;
    private final double[] coefficients;

    private Polynomial(int degree, double[] coefficients) {
        this.degree = degree;
        this.coefficients = coefficients;
    }

    public static Polynomial of(int degree, double... coefficients) {
        if (coefficients.length != degree + 1) {
            throw new IllegalArgumentException("Invalid number of coefficients");
        }
        return new Polynomial(degree, coefficients);
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
                    TextFormatter.formatOperator(coefficient, i == 0),
                    TextFormatter.formatCoefficient(coefficient, i == 0),
                    TextFormatter.formatVariable(deg));
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
        return new WorkingStepImpl(toString(), x, degree, coefficients, result);
    }
}
