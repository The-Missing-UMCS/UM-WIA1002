package com.umwia1002.solution.lab.version2.lab1.Q2.Q2b;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Polynomial poly = new Polynomial(3, new double[]{-4.0, 2.0, -0.5, -20.0});
        System.out.println("The polynomial is " + poly);

        double[] values = {2.0, -3.5};

        Arrays.stream(values)
            .mapToObj(poly::calculate)
            .forEach(workingStep -> System.out.printf("When x = %.2f%n%s%n%n",
                workingStep.substitute(), workingStep));
    }
}
