package com.umwia1002.solution.lab.version1.lab10.recursive;


import com.umwia1002.solution.lab.version1.lab10.SortingAlgorithm;

import java.util.Comparator;

public class QuickSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "QuickSort";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator) {
        if (arr == null || arr.length < 2) {
            return; // No need to sort an empty or single-element array
        }
        quickSort(arr, 0, arr.length - 1, comparator);
    }

    /**
     * Recursive QuickSort method.
     */
    private <T extends Comparable<T>> void quickSort(T[] arr, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, comparator);
            quickSort(arr, low, pivotIndex - 1, comparator); // Sort left partition
            quickSort(arr, pivotIndex + 1, high, comparator); // Sort right partition
        }
    }

    /**
     * Partition method: Rearranges elements around a pivot.
     */
    private <T extends Comparable<T>> int partition(T[] arr, int low, int high, Comparator<T> comparator) {
        T pivot = arr[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Move the pivot to its correct position
        return i + 1;
    }

    /**
     * Utility method to swap two elements in the array.
     */
    private <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
