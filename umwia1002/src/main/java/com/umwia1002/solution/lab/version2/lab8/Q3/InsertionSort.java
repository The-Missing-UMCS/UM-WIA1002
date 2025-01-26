package com.umwia1002.solution.lab.version2.lab8.Q3;

public class InsertionSort extends Sorting {

    public InsertionSort() {
        super("Insertion Sort");
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
}
