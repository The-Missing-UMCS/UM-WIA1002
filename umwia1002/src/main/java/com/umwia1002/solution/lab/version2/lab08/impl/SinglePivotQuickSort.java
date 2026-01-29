package com.umwia1002.solution.lab.version2.lab08.impl;

import java.util.Comparator;

public class SinglePivotQuickSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "Single Pivot Quick Sort";
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length, low = 0, high = n - 1;
        int[] stack = new int[n];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int p = partition(arr, low, high);

            if (p - 1 > low) {
                stack[++top] = low;
                stack[++top] = p - 1;
            }

            if (p + 1 < high) {
                stack[++top] = p + 1;
                stack[++top] = high;
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
        if (n < 2) {
            return;
        }
        int low = 0, high = n - 1;
        int[] stack = new int[n];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int p = partition(arr, low, high, comparator);

            if (p - 1 > low) {
                stack[++top] = low;
                stack[++top] = p - 1;
            }

            if (p + 1 < high) {
                stack[++top] = p + 1;
                stack[++top] = high;
            }
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;

                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }

    public <T> int partition(T[] arr,
                             int low,
                             int high,
                             java.util.Comparator<? super T> comparator) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        T tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }
}
