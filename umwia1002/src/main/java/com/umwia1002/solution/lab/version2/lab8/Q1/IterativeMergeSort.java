package com.umwia1002.solution.lab.version2.lab8.Q1;

import java.util.*;


public class IterativeMergeSort extends MergeSort {

    public IterativeMergeSort(MyComparator conditions) {
        super(conditions);
    }

    public static void main(String[] args) {
        List<Comparator<Integer>> ls = List.of((n1, n2) -> {
            int val1 = n1 & 1, val2 = n2 & 1;
            return -1 * Integer.compare(val1, val2);
        }, Comparator.comparingInt(x -> x));
        
        MyComparator comparators = new MyComparator(ls);
        IterativeMergeSort algo = new IterativeMergeSort(comparators);
        int[] arr = new Random().ints(10, 10, 100).toArray();
        System.out.println(Arrays.toString(arr));
        algo.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int n = arr.length;
        for(int size = 1; size < n; size <<= 1) {
            for(int start = 0; start < n - 1; start += 2 * size) {
                // System.out.println("start = " + start + ", size = " + size);
                int mid = Math.min(start + size - 1, n - 1);
                int end = Math.min(start + (size << 1) - 1, n - 1);
                merge(arr, start, mid, end);
            }
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr, m + 1, right, 0, n2);

        int k = l, lp = 0, rp = 0;
        while(lp < left.length && rp < right.length) {
            if(conditions.compare(left[lp], right[rp]) < 0) {
                arr[k++] = left[lp++];
            } else {
                arr[k++] = right[rp++];
            }
        }

        while(lp < left.length) {
            arr[k++] = left[lp++];
        }

        while(rp < right.length) {
            arr[k++] = right[rp++];
        }
    }
}
