package com.umwia1002.solution.lab.version2.lab08.impl;

import java.util.Comparator;

public class HeapSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "Heap Sort";
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        // Building max heap
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, java.util.Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;

        for (int i = (n >> 1) - 1; i >= 0; i--) {
            heapify(arr, n, i, comparator);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0, comparator);
        }
    }

    public void heapify(int[] arr, int n, int parent) {
        int parentVal = arr[parent];
        int half = n >>> 1;

        while (parent < half) {
            int child = (parent << 1) + 1;
            int childVal = arr[child];
            int right = child + 1;
            if (right < n && arr[right] > arr[child]) {
                childVal = arr[child = right];
            }
            if (childVal <= parentVal) {
                break;
            }
            arr[parent] = childVal;
            parent = child;
        }
        arr[parent] = parentVal;
    }

    public <T> void heapify(T[] arr,
                            int n,
                            int parent,
                            java.util.Comparator<? super T> comparator) {
        T parentVal = arr[parent];
        int half = n >>> 1;

        while (parent < half) {
            int child = (parent << 1) + 1;
            int right = child + 1;
            if (right < n && comparator.compare(arr[right], arr[child]) > 0) {
                child = right;
            }
            if (comparator.compare(arr[child], parentVal) <= 0) {
                break;
            }
            arr[parent] = arr[child];
            parent = child;
        }
        arr[parent] = parentVal;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
