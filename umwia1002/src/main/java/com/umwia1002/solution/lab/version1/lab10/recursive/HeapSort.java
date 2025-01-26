package com.umwia1002.solution.lab.version1.lab10.recursive;

import com.umwia1002.solution.lab.version1.lab10.SortingAlgorithm;

import java.util.Comparator;

public class HeapSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "HeapSort";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, comparator);
        }

        // Remove element
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0, comparator);
        }
    }

    private <T extends Comparable<T>> void heapify(T[] arr, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(arr[left], arr[largest]) > 0)
            largest = left;

        if (right < n && comparator.compare(arr[right], arr[largest]) > 0)
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest, comparator);
        }
    }

    private <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
