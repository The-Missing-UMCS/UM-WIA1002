package com.umwia1002.solution.lab.version2.lab08.l8q1;

public class RecursiveMergeSort extends MergeSort {

    public RecursiveMergeSort(MyComparator conditions) {
        super(conditions);
    }

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr, m + 1, right, 0, n2);

        int k = l, lp = 0, rp = 0;
        while (lp < left.length && rp < right.length) {
            if (conditions.compare(left[lp], right[rp]) < 0) {
                arr[k++] = left[lp++];
            } else {
                arr[k++] = right[rp++];
            }
        }

        while (lp < left.length) {
            arr[k++] = left[lp++];
        }

        while (rp < right.length) {
            arr[k++] = right[rp++];
        }
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (high - low > 1) {
            int mid = (high + low) >> 1;
            mergeSort(arr, 0, mid); // new array
            mergeSort(arr, mid + 1, high); // new array
            merge(arr, low, mid, high);
        }
    }
}
