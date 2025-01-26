package com.umwia1002.solution.lab.version2.lab1.Q2.Q2c;


import com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.decorator.LaTeXDecorator;
import com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.domain.Polynomial;
import com.umwia1002.solution.lab.version2.lab1.Q2.Q2c.domain.WorkingStep;
import com.umwia1002.solution.util.LaTeXUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Polynomial poly = Polynomial.of(3, -4.0, 2.0, -0.5, -20.0);
        System.out.println("Polynomial: " + poly);

        double[] values = {2.0, -3.5};
        Arrays.stream(values)
            .mapToObj(poly::calculate)
            .forEach(Main::renderStep);
    }

    private static void renderStep(WorkingStep workingStep) {
        LaTeXDecorator latexStep = new LaTeXDecorator(workingStep);
        System.out.printf("When x = %.2f%n%s%n%n", latexStep.substitute(), latexStep);
        LaTeXUtil.render(latexStep.toLaTeX());
    }
}
