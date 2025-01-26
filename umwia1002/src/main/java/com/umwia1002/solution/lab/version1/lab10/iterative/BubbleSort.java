package com.umwia1002.solution.lab.version1.lab10.iterative;


import com.umwia1002.solution.lab.version1.lab10.SortingAlgorithm;

import java.util.Comparator;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "BubbleSort";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator) {
        boolean isSwap;

        for (int i = 0; i < arr.length; i++) {
            isSwap = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSwap = true;
                }
            }

            if (!isSwap) break;
        }
    }
}
