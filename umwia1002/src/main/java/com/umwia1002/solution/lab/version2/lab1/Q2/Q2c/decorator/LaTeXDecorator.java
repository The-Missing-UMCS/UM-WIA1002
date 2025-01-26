package com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.decorator;

import com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.domain.WorkingStep;
import com.umwia1002.solution.util.LaTeXUtil;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class LaTeXDecorator implements WorkingStep {
    private final WorkingStep workingStep;

    private static String toLatex(String expression) {
        return expression.replaceAll("\\^(\\d+)\\s", "^{$1}").trim();
    }

    @Override
    public String initialExpression() {
        return LaTeXUtil.format(toLatex(workingStep.initialExpression()));
    }

    @Override
    public String afterSubstitution() {
        return LaTeXUtil.format(toLatex(workingStep.afterSubstitution()));
    }

    @Override
    public String afterSimplification() {
        return LaTeXUtil.format(workingStep.afterSimplification());
    }

    @Override
    public String afterEvaluation() {
        return LaTeXUtil.format(workingStep.afterEvaluation());
    }

    @Override
    public double substitute() {
        return workingStep.substitute();
    }

    @Override
    public double[] coefficients() {
        return workingStep.coefficients();
    }

    @Override
    public double result() {
        return workingStep.result();
    }

    public String toLaTeX() {
        return """
            \\[
            %s \\\\
            = %s \\\\
            = %s \\\\
            = %.2f
            \\]
            """.formatted(
            initialExpression(),
            afterSubstitution(),
            afterSimplification(),
            result()
        );
    }

    @Override
    public String toString() {
        return toLaTeX();
    }
}
