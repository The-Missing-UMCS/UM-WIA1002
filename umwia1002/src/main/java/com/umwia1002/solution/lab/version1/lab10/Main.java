package com.umwia1002.solution.lab.version1.lab10;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr;

        // Q1
        arr = new int[]{45, 7, 2, 8, 19, 3};
        selectionSortSmallest(arr);
        System.out.println("Selection sort ascending: " + Arrays.toString(arr));

        // Q2
        arr = new int[]{45, 7, 2, 8, 19, 3};
        selectionSortLargest(arr);
        System.out.println("Selection sort descending: " + Arrays.toString(arr));

        // Q4
        arr = new int[]{10, 34, 2, 56, 7, 67, 88, 42};
        insertionSort(arr);
        System.out.println("Insertion sort ascending: " + Arrays.toString(arr));
    }

    // Q1
    private static void selectionSortSmallest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
        }
    }


    // Q2
    private static void selectionSortLargest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int largest = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[largest]) {
                    largest = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
        }
    }

    // Q4
    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

//			int j;
//            for (j = i-1; j >= 0 && key < arr[j]; j--)
//                arr[j+1] = arr[j];

            // Because j now is -1
            arr[j + 1] = key;
        }
    }
}
