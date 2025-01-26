package com.umwia1002.solution.lab.version1.lab10.recursive;

import com.umwia1002.solution.lab.version1.lab10.SortingAlgorithm;

import java.lang.reflect.Array;
import java.util.Comparator;

public class IterativeMergeSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "IterativeMergeSort";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        for (int size = 1; size < n; size = size << 1) {
            for (int from = 0; from < n; from += 2 * size) {
                int mid = Math.min(from + size - 1, n - 1);
                int to = Math.min(from + 2 * size - 1, n - 1);
                merge(arr, from, mid, to, comparator);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> void merge(T[] arr, int from, int mid, int to, Comparator<T> comparator) {
        int n1 = mid - from + 1;
        int n2 = to - mid;

        T[] left = (T[]) Array.newInstance(arr.getClass().getComponentType(), n1);
        T[] right = (T[]) Array.newInstance(arr.getClass().getComponentType(), n2);

        // Initialize two arrays named left and right
        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + from];
        }

        for (int i = 0; i < n2; i++)
            right[i] = arr[i + mid + 1];

        int i = 0, j = 0, k = from;

        while (i < n1 && j < n2) {
            if (comparator.compare(left[i], right[j]) < 0)
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < n1)
            arr[k++] = left[i++];

        while (j < n2)
            arr[k++] = right[j++];

    }
}
