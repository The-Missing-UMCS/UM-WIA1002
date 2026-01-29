package com.umwia1002.solution.lab.version2.lab01.l1q2.l1q2a;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Polynomial poly = new Polynomial(3, new double[]{4.0, 2.0, -0.5, -20.0});
        System.out.println("The polynomial is " + poly);

        double[] values = {2.0, -3.5};

        Arrays.stream(values).forEach(value ->
            System.out.printf("When x = %.2f%n%s", value, poly.calculateAsString(value)));
    }
}
