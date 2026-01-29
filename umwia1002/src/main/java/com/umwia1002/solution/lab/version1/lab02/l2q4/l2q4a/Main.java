package com.umwia1002.solution.lab.version1.lab02.l2q4.l2q4a;

public class Main {

    public static void main(String[] args) {
        System.out.println(minmax(new Integer[]{5, 3, 7, 1, 4, 9, 8, 2}));
        System.out.println(minmax(new String[]{"red", "blue", "orange", "tan"}));
    }

    public static <T extends Comparable<T>> String minmax(T[] args) {
        T min = args[0], max = args[0];

        for (int i = 1; i < args.length; i++) {
            if (args[i].compareTo(min) < 0) {
                min = args[i];
            } else if (args[i].compareTo(max) > 0) {
                max = args[i];
            }
        }
        return String.format("Min = %s, Max = %s", min, max);
    }
}
