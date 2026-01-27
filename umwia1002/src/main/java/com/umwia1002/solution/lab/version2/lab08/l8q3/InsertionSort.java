package com.umwia1002.solution.lab.version2.lab08.l8q3;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "Insertion Sort";
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, java.util.Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] arr, java.util.Comparator<? super T> comparator) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            T key = arr[i];

            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
