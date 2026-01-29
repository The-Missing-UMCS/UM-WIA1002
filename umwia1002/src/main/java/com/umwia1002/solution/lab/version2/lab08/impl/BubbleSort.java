package com.umwia1002.solution.lab.version2.lab08.impl;

import java.util.Comparator;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "Bubble Sort";
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    isSwap = true;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, java.util.Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j + 1], arr[j]) < 0) {
                    isSwap = true;
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }
}
