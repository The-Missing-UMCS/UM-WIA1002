package com.umwia1002.solution.lab.version2.lab09;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class l9q2 {

    public static final int SIZE = 10;
    public static final int ORIGIN = 0;
    public static final int BOUND = 21;

    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = new LinkedList<>(rand.ints(SIZE, ORIGIN, BOUND).boxed().toList());

        // 1.
        System.out.print("The random integers are :");
        for (int val : list) {
            System.out.print(val + " --> ");
        }
        System.out.println();

        // 2.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Linear Search");
            System.out.print("Enter a number to search: ");
            int number = scanner.nextInt();

            // 2.1
            boolean found;

            found = contains(list, number);
            System.out.printf("%d is %s found%n", number, found ? "" : "not");

            // 2.2
            if (found) {
                System.out.printf("The number of %d in the data set is %d%n", number,
                    frequency(list, number));
            }

            // 2.3
            System.out.print("Enter two numbers to search (begin end): ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            found = contains(list, start, end);
            System.out.printf("The integer can be found in between %d and %d%n", start, end);
            if (found) {
                System.out.printf(
                    "The number of elements in between %d and %d in the data set is %d%n", start,
                    end, frequency(list, start, end));
            }

        }


    }

    private static boolean contains(List<Integer> list, int target) {
        for (int val : list) {
            if (val == target) {
                return true;
            }
        }
        return false;
    }

    private static int frequency(List<Integer> list, int target) {
        int count = 0;
        for (int val : list) {
            if (val == target) {
                count++;
            }
        }
        return count;
    }

    private static boolean contains(List<Integer> list, int startInclusive, int endInclusive) {
        for (int val : list) {
            if (val >= startInclusive && val <= endInclusive) {
                return true;
            }
        }
        return false;
    }

    private static int frequency(List<Integer> list, int startInclusive, int endInclusive) {
        int count = 0;
        for (int val : list) {
            if (val >= startInclusive && val <= endInclusive) {
                count++;
            }
        }
        return count;
    }
}
