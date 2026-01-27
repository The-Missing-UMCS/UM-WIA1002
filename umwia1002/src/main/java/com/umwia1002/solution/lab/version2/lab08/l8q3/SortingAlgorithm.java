package com.umwia1002.solution.lab.version2.lab08.l8q3;

import java.util.Comparator;

public interface SortingAlgorithm {
    String name();

    void sort(int[] arr);

    <T extends Comparable<? super T>> void sort(T[] arr);

    <T> void sort(T[] arr, Comparator<? super T> comparator);
}
