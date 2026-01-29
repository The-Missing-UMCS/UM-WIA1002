package com.umwia1002.solution.lab.version2.lab08.l8q1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        List<Comparator<Integer>> ls = List.of((n1, n2) -> {
            int val1 = n1 & 1, val2 = n2 & 1;
            return -1 * Integer.compare(val1, val2);
        }, Comparator.comparingInt(x -> x));

        MyComparator condition = new MyComparator(ls);
        IterativeMergeSort algo1 = new IterativeMergeSort(condition);
        RecursiveMergeSort algo2 = new RecursiveMergeSort(condition);

        int n;
        int[] arr;

        System.out.print("Enter N Special Random Number within 0-100: ");
        n = sc.nextInt();
        sc.close();

        arr = rand.ints(n, 10, 100).toArray();
        System.out.println("The Special Number are : " + Arrays.toString(arr) + "\n");

        testAlgo("Iterative Merge Sort", algo1, arr);
        testAlgo("Recursive Merge Sort", algo2, arr);
    }

    public static void testAlgo(String algoName, MergeSort algo, int[] arr) {
        int[] copy = arr.clone();
        System.out.print("After " + algoName + ": ");
        long start = System.nanoTime();
        algo.sort(copy);
        long end = System.nanoTime();
        System.out.println(Arrays.toString(copy));
        System.out.println("Time used: " + (end - start) + " nanoseconds\n");
    }
}