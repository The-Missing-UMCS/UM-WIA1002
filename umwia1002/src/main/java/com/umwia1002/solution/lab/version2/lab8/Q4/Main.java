package com.umwia1002.solution.lab.version2.lab8.Q4;

import com.umwia1002.solution.lab.version2.lab8.Q3.MergeSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort sort = new MergeSort();
        System.out.print("Enter N characters : ");
        final int N = sc.nextInt();
        sc.nextLine();
        int[] chars = new int[N];
        System.out.print("The characters are : ");
        for(int i = 0; i < N; i++) {
            chars[i] = sc.next().charAt(0);
        }
        sc.close();
        printChars(chars);
        sort.sort(chars);
        printChars(chars);
    }

    public static void printChars(int[] arr) {
        for(int ch : arr)
            System.out.print((char) ch + " ");
        System.out.println();
    }
}
