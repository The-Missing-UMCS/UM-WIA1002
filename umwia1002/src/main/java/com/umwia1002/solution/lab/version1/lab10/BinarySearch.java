package com.umwia1002.solution.lab.version1.lab10;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static int search(int[] array, int target) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = array[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int search(E[] array, E target) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            E midVal = array[mid];
            int cmp = midVal.compareTo(target);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int search(List<E> list, E target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            E midVal = list.get(mid);
            int cmp = midVal.compareTo(target);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
