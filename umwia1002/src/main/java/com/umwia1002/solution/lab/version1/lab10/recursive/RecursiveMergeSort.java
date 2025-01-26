package com.umwia1002.solution.lab.version1.lab10.recursive;

import com.umwia1002.solution.lab.version1.lab10.SortingAlgorithm;

import java.lang.reflect.Array;
import java.util.Comparator;

public class RecursiveMergeSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "RecursiveMergeSort";
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> void sort(T[] arr, Comparator<T> comparator) {
        if (arr.length > 1) {
            int N = arr.length;

            // 1. Create arrays of the correct generic type using reflection
            T[] left = (T[]) Array.newInstance(arr.getClass().getComponentType(), N / 2);
            T[] right = (T[]) Array.newInstance(arr.getClass().getComponentType(), N - N / 2);

            // 2. Copy the elements from the original array to the left and right arrays
            System.arraycopy(arr, 0, left, 0, N / 2);
            System.arraycopy(arr, N / 2, right, 0, N - N / 2);

            // 3. Sort the left and right arrays
            sort(left, comparator); // Recursive call on the left array
            sort(right, comparator); // Recursive call on the right array

            // 4. Merge the sorted left and right arrays
            merge(arr, left, right, comparator);
        }
    }

    private <T extends Comparable<T>> void merge(T[] arr, T[] left, T[] right, Comparator<T> comparator) {
        // Initialize three pointers
        int k = 0, i = 0, j = 0;

        // Merge the array
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) < 0)
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        // When we run out of elements in either left or right,
        // pick up the remaining elements and put in arr[]
        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];
    }
}
