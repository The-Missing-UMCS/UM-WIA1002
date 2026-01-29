package com.umwia1002.solution.lab.version1.lab02.l2q5.l2q5a;

public class FindMax {

    public static <E extends Comparable<E>> E max(E[] list) {
        if (list == null || list.length == 0) {
            return null;
        }

        E max = list[0];
        for (E item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }
}
