package com.umwia1002.solution.lab.version1.lab10;

import java.util.Comparator;

public interface SortingAlgorithm {
    String name();

    <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator);

    default <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, Comparator.naturalOrder());
    }

    default <T extends Comparable<T>> void sortDescending(T[] arr) {
        sort(arr, Comparator.reverseOrder());
    }
}
