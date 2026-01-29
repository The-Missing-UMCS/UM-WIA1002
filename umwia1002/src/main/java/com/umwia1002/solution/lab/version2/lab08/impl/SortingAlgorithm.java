package com.umwia1002.solution.lab.version2.lab08.impl;

import java.util.Comparator;

public interface SortingAlgorithm {

    String name();

    void sort(int[] arr);

    <T extends Comparable<? super T>> void sort(T[] arr);

    <T> void sort(T[] arr, Comparator<T> comparator);
}
