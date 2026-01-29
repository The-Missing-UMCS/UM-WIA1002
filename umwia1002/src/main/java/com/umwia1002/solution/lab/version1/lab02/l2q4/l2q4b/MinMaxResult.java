package com.umwia1002.solution.lab.version1.lab02.l2q4.l2q4b;

public record MinMaxResult<T extends Comparable<T>>(
    T min,
    T max
) {

}
