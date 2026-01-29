package com.umwia1002.solution.tutorial.tutorial10.t10q2;

public class MergeSort extends SortingAlgorithm {

    public String name() {
        return "Merge Sort";
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        int i = 1;
        for (int size = 1; size < n; size = size << 1) {
            for (int from = 0; from < n; from += size * 2) {
                int to = Math.min(from + (size << 1) - 1, n - 1);
                int mid = Math.min(from + size - 1, n - 1); // (to + from) >> 1
                merge(arr, from, mid, to);
            }
            System.out.printf(" %3d --> %s%n", i++, toString(arr, size));
        }
    }

    private void merge(int[] arr, int from, int mid, int to) {
        int n1 = mid - from + 1;
        int n2 = to - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + from];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[i + mid + 1];
        }

        int p1 = 0, p2 = 0, p = from;

        while (p1 < n1 && p2 < n2) {
            if (left[p1] < right[p2]) {
                arr[p++] = left[p1++];
            } else {
                arr[p++] = right[p2++];
            }
        }

        while (p1 < n1) {
            arr[p++] = left[p1++];
        }

        while (p2 < n2) {
            arr[p++] = right[p2++];
        }
    }

    private String toString(int[] arr, int size) {
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int from = 0; from < n; from += (size << 1)) {
            sb.append('[');
            int to = Math.min(from + (size << 1) - 1, n - 1);
            for (int i = from; i <= to; i++) {
                sb.append(arr[i]).append(',').append(' ');
            }
            sb.setLength(sb.length() - 2);
            sb.append(']').append(' ').append(':').append(' ');
        }
        sb.setLength(sb.length() - 3);
        return sb.toString();
    }
}
