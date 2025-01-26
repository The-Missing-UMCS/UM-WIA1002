package com.umwia1002.solution.lab.version2.lab8.Q3;

public class MergeSort extends Sorting {
    
    public MergeSort() {
        super("Merge Sort");
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for(int size = 1; size < n; size <<= 1) {
            for(int l = 0; l < n; l += (size << 1)) {
                int m = Math.min(l + size - 1, n - 1);
                int r = Math.min(l + (size << 1) - 1, n - 1);
                merge(arr, l, m, r);
            }
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr, m + 1, right, 0, n2);

        int p = l, lp = 0, rp = 0;
        while(lp < n1 && rp < n2) {
            if(left[lp] < right[rp]) {
                arr[p++] = left[lp++];
            } else {
                arr[p++] = right[rp++];
            }
        }

        while(lp < n1) {
            arr[p++] = left[lp++];
        }

        while(rp < n2) {
            arr[p++] = right[rp++];
        }
    }
}
