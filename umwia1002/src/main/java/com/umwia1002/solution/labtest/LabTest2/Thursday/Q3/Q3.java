package com.umwia1002.solution.labtest.LabTest2.Thursday.Q3;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        int[] queue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        output(queue, 3);
        output(queue, 4);
        output(queue, 5);
    }

    public static void output(int[] originalQueue, int k) {
        System.out.println("Original Queue : " + Arrays.toString(originalQueue));
        System.out.println("Reversed Queue : " + Arrays.toString(reverse(originalQueue, k)));
        System.out.println();
    }

    public static int[] reverse(int[] originalQueue, int k) {
        int[] reversedQueue = Arrays.copyOf(originalQueue, originalQueue.length);

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            queue.add(reversedQueue[i]);
        }

        for(int i = k - 1; i >= 0; i--) {
            reversedQueue[i] = queue.poll();
        }

        return reversedQueue;
    }
    


}
