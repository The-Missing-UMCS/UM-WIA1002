package com.umwia1002.solution.lab.version2.lab09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class l9q1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter N : ");
            int n = scanner.nextInt();

            int[][] matrix = generateMatrix(n);
            System.out.println("The matrix are : ");
            printMatrix(matrix);

            System.out.println();
            System.out.println("Linear Search");
            System.out.print("Enter a number to search: ");
            int target = scanner.nextInt();

            boolean found = contains(matrix, target);
            if (!found) {
                System.out.println(target + " is not found");
                return;
            }

            System.out.printf("%d is found%n", target);
            System.out.printf("The number of %d in the matrix is %d%n", target,
                frequency(matrix, target));

            List<int[]> locations = findLocations(matrix, target);
            System.out.print("The location of " + target + " are : ");
            for (int[] pos : locations) {
                System.out.print("[" + pos[0] + "," + pos[1] + "]");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int n) {
        Random random = new Random();
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = 10 + random.nextInt(10);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    private static boolean contains(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int frequency(int[][] matrix, int target) {
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value == target) {
                    count++;
                }
            }
        }
        return count;
    }

    private static List<int[]> findLocations(int[][] matrix, int target) {
        List<int[]> locations = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    locations.add(new int[]{row, col});
                }
            }
        }
        return locations;
    }
}
