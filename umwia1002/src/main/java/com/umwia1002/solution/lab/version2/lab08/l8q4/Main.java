package com.umwia1002.solution.lab.version2.lab08.l8q4;

import com.umwia1002.solution.lab.version2.lab08.impl.SortingAlgorithms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter N characters : ");
            final int N = sc.nextInt();
            sc.nextLine();
            int[] chars = new int[N];
            System.out.print("The characters are : ");
            for (int i = 0; i < N; i++) {
                chars[i] = sc.next().charAt(0);
            }
            printChars(chars);
            SortingAlgorithms.mergeSort().sort(chars);
            printChars(chars);
        }
    }

    public static void printChars(int[] arr) {
        for (int ch : arr) {
            System.out.print((char) ch + " ");
        }
        System.out.println();
    }
}
