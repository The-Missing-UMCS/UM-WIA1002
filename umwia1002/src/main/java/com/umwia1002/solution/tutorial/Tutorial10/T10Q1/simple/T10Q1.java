package com.umwia1002.solution.tutorial.tutorial10.t10q1.simple;

import java.util.Arrays;

public class t10q1 {
    /* List: 3 8 12 34 54 85 61 110
     *
     * To determine the index of a specific element,
     *
     * Linear search requires traversing and comparing every element in the list,
     * resulting in a time complexity of O(n).
     *
     * Binary search divides the list in half with each comparison,
     * resulting in a time complexity of O(logN).
     *
     * Thus, binary search is more efficient than linear search in terms of time complexity.
     */

    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 34, 54, 85, 61, 110};
        int target1 = 45, target2 = 54;

        System.out.println(Arrays.toString(arr));

        System.out.println("Target 1 = " + target1);
        System.out.print("Linear search: ");
        System.out.println("Result: " + linearSearch(arr, target1));
        System.out.print("Binary search: ");
        System.out.println("Result: " + binarySearch(arr, target1));

        System.out.println();

        System.out.println("Target 2 = " + target2);
        System.out.print("Linear search: ");
        System.out.println("Result: " + linearSearch(arr, target2));
        System.out.print("Binary search: ");
        System.out.println("Result: " + binarySearch(arr, target2));
    }

    public static int linearSearch(int[] arr, int target) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == target) {
                break;
            }
            i++;
        }
        System.out.println(i + " cycle(s) used.");
        return i == arr.length ? -1 : i;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1, count = 0, mid = 0;
        while (low <= high) {
            count++;
            mid = (high + low) >> 1;
            if (arr[mid] == target) {
                break;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(count + " cycle(s) used");
        return low > high ? -1 : mid;
    }
}
