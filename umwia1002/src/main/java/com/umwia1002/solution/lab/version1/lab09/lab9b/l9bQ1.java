package com.umwia1002.solution.lab.version1.lab09.lab9b;

import java.util.Arrays;

public class l9bQ1 {

    public static void main(String[] args) {
        int[][] values = {
            {1, 1},
            {4, 10},
            {12, 8},
            {7, 12}
        };
        Arrays.stream(values)
            .forEach(pair -> System.out.printf("F(%d,%d) = %d\n", pair[0], pair[1],
                F(pair[0], pair[1])));
    }

    public static int F(int s, int t) {
        if (s == 1 || t == 1) {
            return s;
        }
        return F(s - 1, t) + F(s, t - 1);
    }
}
