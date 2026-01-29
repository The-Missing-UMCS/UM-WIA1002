package com.umwia1002.solution.lab.version1.lab10.iterative;

import com.umwia1002.solution.lab.version1.lab10.SortingAlgorithm;

import java.util.Comparator;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "SelectionSort";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;

            for (int j = 1 + i; j < arr.length; j++) {
                // if isAscending = true, index = minIndex else index = maxIndex
                if (comparator.compare(arr[j], arr[index]) < 0) {
                    index = j;
                }
            }

            if (index != i) {
                T tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
    }
}
