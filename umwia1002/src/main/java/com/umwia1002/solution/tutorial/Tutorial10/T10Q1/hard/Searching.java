package com.umwia1002.solution.tutorial.tutorial10.t10q1.hard;

public class Searching {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        } else {
            int mid = (high + low) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchRecursive(arr, mid + 1, high, target);
            } else {
                return binarySearchRecursive(arr, low, mid - 1, target);
            }
        }
    }
}
