package com.umwia1002.solution.lab.version1.lab2.L2Q4;

import java.util.Arrays;
import java.util.Comparator;

public class Tools {
    public static <T extends Comparable<T>> MinMaxAnswer<T> minmax(T[] args) {
        T min = args[0], max = args[0];

        for (int i = 1; i < args.length; i++) {
            if (args[i].compareTo(min) < 0)
                min = args[i];

            else if (args[i].compareTo(max) > 0)
                max = args[i];
        }
        return new MinMaxAnswer<>(min, max);
    }

    public static <T extends Comparable<T>> MinMaxAnswer<T> minMax(T[] args) {
        T min = Arrays.stream(args).min(Comparator.naturalOrder()).orElse(null);
        T max = Arrays.stream(args).max(Comparator.naturalOrder()).orElse(null);
        return new MinMaxAnswer<>(min, max);
    }

}
