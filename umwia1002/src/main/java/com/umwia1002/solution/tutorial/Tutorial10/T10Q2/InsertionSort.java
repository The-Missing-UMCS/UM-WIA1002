package com.umwia1002.solution.tutorial.Tutorial10.T10Q2;

import java.util.Arrays;

public class InsertionSort extends SortingAlgorithm {
	InsertionSort() {
		super("Insertion Sort");
	}
	
	@Override
	public void sort(int[] arr) {
		System.out.printf(" %3d --> %s\n", 0, Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = key;
			printPos(j + 1, i);
			System.out.printf(" %3d --> %s\n", i, Arrays.toString(arr));
		}
		System.out.println();
	}
	
	
}
