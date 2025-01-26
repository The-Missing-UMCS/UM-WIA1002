package com.umwia1002.solution.lab.version2.lab8.Q3;

public class SinglePivotQuickSort extends Sorting {

    public SinglePivotQuickSort() {
        super("Single Pivot Quick Sort");
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length, low = 0, high = n - 1;
        int[] stack = new int[n];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while(top >= 0) {
            high = stack[top--];
            low = stack[top--];
            
            int p = partition(arr, low, high);
            
            if(p - 1 > low) {
                stack[++top] = low;
                stack[++top] = p - 1;
            }

            if(p + 1 < high) {
                stack[++top] = p + 1;
                stack[++top] = high;
            }
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++) {
            if(arr[j] <= pivot) {
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
}
