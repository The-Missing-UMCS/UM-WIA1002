package com.umwia1002.solution.lab.version2.lab8.Q3;

public class SelectionSort extends Sorting {

    public SelectionSort() {
        super("Selection Sort");
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int min = i;

            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            int tmp = arr[i];
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
