package com.umwia1002.solution.lab.version2.lab08.l8q3;

import java.util.*;

public class SortTest {

    public static void main(String[] args) {
        // Generating 1000 sets of 100000 random numbers
        int numOfSet = 1000, numOfNumber = 1000;
        Random rand = new Random();
        int[][] matrix = new int[numOfSet][numOfNumber];
        for (int row = 0; row < numOfSet; row++) {
            matrix[row] = rand.ints(numOfNumber, 0, numOfNumber * 10).toArray();
        }

        SortingAlgorithm[] ls = { new BubbleSort(), new InsertionSort(), new SelectionSort(),
                new HeapSort(), new MergeSort(), new SinglePivotQuickSort(), new DualPivotQuickSort() };

        System.out.println("Performance Comparison of Sorting Algorithms");
        System.out.println("Running on 1000 sets of 100000 random numbers");
        long minTime = Integer.MAX_VALUE, maxTime = Integer.MIN_VALUE;
        int minIndex = -1, maxIndex = -1;

        for (int i = 0; i < ls.length; i++) {
            SortingAlgorithm algo = ls[i];
            long timeUsed = testAlgo(algo.name(), algo, matrix);

            if (timeUsed < minTime) {
                minTime = timeUsed;
                minIndex = i;
            }

            if (timeUsed > maxTime) {
                maxTime = timeUsed;
                maxIndex = i;
            }
        }

        System.out.println();
        System.out.printf(" +++++  Fastest Algorithm:  %-25s (%d ms)%n", ls[minIndex].name(), minTime);
        System.out.printf(" -----  Slowest Algorithm:  %-25s (%d ms)\n", ls[maxIndex].name(), maxTime);
    }

    public static long testAlgo(String algoName, SortingAlgorithm algo, int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] copy = cloneMatrix(matrix, row, col);
        System.out.printf("  \\-->  %-25s : ", algoName);
        long start = System.currentTimeMillis();
        for (int i = 0; i < matrix.length; i++) {
            algo.sort(copy[i]);
        }
        long end = System.currentTimeMillis();
        long timeUsed = end - start;
        System.out.println(timeUsed + " ms");
        return timeUsed;
    }

    public static int[][] cloneMatrix(int[][] matrix, int row, int col) {
        int[][] cloned = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(matrix[i], 0, cloned[i], 0, col);
        }
        return cloned;
    }
}
