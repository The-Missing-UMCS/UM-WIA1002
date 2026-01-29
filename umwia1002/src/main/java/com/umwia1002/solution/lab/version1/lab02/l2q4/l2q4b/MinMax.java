package com.umwia1002.solution.lab.version1.lab02.l2q4.l2q4b;

import java.util.Arrays;
import java.util.Comparator;

public class MinMax {

    public static <T extends Comparable<T>> MinMaxResult<T> minmax(T[] args) {
        T min = args[0], max = args[0];

        for (int i = 1; i < args.length; i++) {
            if (args[i].compareTo(min) < 0) {
                min = args[i];
            } else if (args[i].compareTo(max) > 0) {
                max = args[i];
            }
        }
        return new MinMaxResult<>(min, max);
    }

    public static <T extends Comparable<T>> MinMaxResult<T> minMax(T[] args) {
        T min = Arrays.stream(args).min(Comparator.naturalOrder()).orElse(null);
        T max = Arrays.stream(args).max(Comparator.naturalOrder()).orElse(null);
        return new MinMaxResult<>(min, max);
    }

}
