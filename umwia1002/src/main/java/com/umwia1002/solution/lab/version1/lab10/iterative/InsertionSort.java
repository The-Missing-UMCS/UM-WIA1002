package com.umwia1002.solution.lab.version1.lab10.iterative;

import com.umwia1002.solution.lab.version1.lab10.SortingAlgorithm;

import java.util.Comparator;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "InsertionSort";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

    }
}
