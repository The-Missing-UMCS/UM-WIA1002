package com.umwia1002.solution.lab.version2.lab8.Q3;

public class HeapSort extends Sorting {

    public HeapSort() {
        super("Heap Sort");
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        // Building max heap
        for(int i = (arr.length >> 1) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
          }
    }

    public void heapify(int[] arr, int n, int parent) {
        int parentVal = arr[parent];
        int half = n >>> 1;

        while (parent < half) {
            int child = (parent << 1) + 1;
            int childVal = arr[child];
            int right = child + 1;
            if (right < n && arr[right] > arr[child])
                childVal = arr[child = right];
            if (childVal <= parentVal)
                break;
            arr[parent] = childVal;
            parent = child;
        }
        arr[parent] = parentVal;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
