package com.umwia1002.solution.labtest.LabTest2.Wednesday.Q3;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        output(new int[] { 4, 3, 8, 9, 0, 1 }, 3);
        output(new int[] { 9, 8, 6, 4, 3, 1 }, 4);
        output(new int[] { 1, 2, 3, 4, 10, 6, 9, 8, 7, 5 }, 3);
    }

    public static void output(int[] array, int k) {
        int[] allMax = allMax(array, k);

        System.out.printf("Input arr[]: %s, k = %d%n", Arrays.toString(array), k);
        System.out.printf("Output: %s%n", Arrays.toString(allMax));
        System.out.println(
                "Explanation: The window size is " + k + " and the maximum at different iterations are as follows:");

        for (int i = 0; i < array.length - k + 1; i++) {
            int[] window = Arrays.copyOfRange(array, i, i + k);
            System.out.printf("max(%s) = %d%n", Arrays.toString(window).replace("[", "").replace("]", ""), allMax[i]);
        }

        System.out.printf("Hence, we get arr = %s as output.%n%n", Arrays.toString(allMax));
    }

    public static int[] allMax(int[] arr, int k) {
        int size = arr.length - k + 1;
        int[] array = new int[size];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Add the first 'k' elements to the priority queue
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        array[0] = pq.peek();

        // Process the remaining elements using the sliding window approach
        for (int i = k; i < arr.length; i++) {
            pq.remove(arr[i - k]); // Remove the outgoing element from the window
            pq.add(arr[i]); // Add the incoming element to the window
            array[i - k + 1] = pq.peek();
        }

        return array;
    }

}
