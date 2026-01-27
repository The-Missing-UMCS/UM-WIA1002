package com.umwia1002.solution.lab.version2.lab08.l8q3;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "Selection Sort";
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, java.util.Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] arr, java.util.Comparator<? super T> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(arr[j], arr[min]) < 0) {
                    min = j;
                }
            }

            T tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] arr = new int[] { 2, 1, 7, 4 };
        sort.sort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
