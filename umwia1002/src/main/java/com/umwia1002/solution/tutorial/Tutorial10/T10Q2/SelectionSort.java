package com.umwia1002.solution.tutorial.tutorial10.T10Q2;

import java.util.Arrays;

public class SelectionSort extends SortingAlgorithm {
	public String name() {
		return "Selection Sort";
	}
	
	@Override
	public void sort(int[] arr) {
		System.out.printf(" %3d --> %s\n", 0, Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[min])
					min = j;
			swap(arr, i, min);
			printPos(i, min);
			System.out.printf(" %3d --> %s\n", i + 1, Arrays.toString(arr));
		}
		System.out.println();
	}
}