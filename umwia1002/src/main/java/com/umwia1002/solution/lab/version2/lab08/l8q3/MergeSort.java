package com.umwia1002.solution.lab.version2.lab08.l8q3;

public class MergeSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "Merge Sort";
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int size = 1; size < n; size <<= 1) {
            for (int l = 0; l < n; l += (size << 1)) {
                int m = Math.min(l + size - 1, n - 1);
                int r = Math.min(l + (size << 1) - 1, n - 1);
                merge(arr, l, m, r);
            }
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, java.util.Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] arr, java.util.Comparator<? super T> comparator) {
        int n = arr.length;
        Object[] temp = new Object[n];
        for (int size = 1; size < n; size <<= 1) {
            for (int l = 0; l < n; l += (size << 1)) {
                int m = Math.min(l + size - 1, n - 1);
                int r = Math.min(l + (size << 1) - 1, n - 1);
                merge(arr, temp, l, m, r, comparator);
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
        while (lp < n1 && rp < n2) {
            if (left[lp] < right[rp]) {
                arr[p++] = left[lp++];
            } else {
                arr[p++] = right[rp++];
            }
        }

        while (lp < n1) {
            arr[p++] = left[lp++];
        }

        while (rp < n2) {
            arr[p++] = right[rp++];
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void merge(T[] arr, Object[] temp, int l, int m, int r,
            java.util.Comparator<? super T> comparator) {
        int i = l;
        int j = m + 1;
        int k = l;

        while (i <= m && j <= r) {
            if (comparator.compare(arr[i], arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (int idx = l; idx <= r; idx++) {
            arr[idx] = (T) temp[idx];
        }
    }
}
