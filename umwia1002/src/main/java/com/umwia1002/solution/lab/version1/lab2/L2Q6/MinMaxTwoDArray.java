package com.umwia1002.solution.lab.version1.lab2.L2Q6;

import java.util.Arrays;

public class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list) {
        if (list == null)
            return null;

        E min = null;
        for (E[] row : list) {
            if (row == null) {
                continue;
            }
            for (E item : row) {
                if (item != null && (min == null || item.compareTo(min) < 0)) {
                    min = item;
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        if (list == null)
            return null;

        E max = null;
        for (E[] row : list) {
            if (row == null) {
                continue;
            }
            for (E item : row) {
                if (item != null && (max == null || item.compareTo(max) > 0)) {
                    max = item;
                }
            }
        }
        return max;
    }

    public static <E extends Comparable<E>> E streamMin(E[][] list) {
        return Arrays.stream(list)
            .flatMap(Arrays::stream)
            .min(Comparable::compareTo)
            .orElse(null);
    }

    public static <E extends Comparable<E>> E streamMax(E[][] list) {
        return Arrays.stream(list)
            .flatMap(Arrays::stream)
            .max(Comparable::compareTo)
            .orElse(null);
    }
}
