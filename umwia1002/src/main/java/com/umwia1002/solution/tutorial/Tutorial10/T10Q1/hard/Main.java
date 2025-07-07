package com.umwia1002.solution.tutorial.tutorial10.T10Q1.hard;

import java.util.Arrays;
import java.util.Random;

public class Main {
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		int initialSize = 10;
		int finalSize = 100_000;
		runComparison(initialSize, finalSize, 1, 1_000_000, 1000);
	}

	/**
	 * Orchestrates the entire comparison process, from iterating over sizes to
	 * collecting search-time results and finally plotting or printing them.
	 *
	 * @param initialSize The smallest array size to test
	 * @param finalSize   The largest array size to test
	 * @param low         The lowest integer value to generate in the array
	 * @param high        The highest integer value to generate in the array
	 * @param repeat      How many times to run the searches for averaging
	 */
	private static void runComparison(int initialSize, int finalSize,
									  int low, int high, int repeat) {

		// Determine how many data points based on 10x growth from initial to final size
		int length = (int) Math.log10(finalSize / initialSize) + 1;

		// xAxis for the array sizes; yAxis for search times: [0]=linear, [1]=iter. binary, [2]=rec. binary
		int[] xAxis = new int[length];
		long[][] yAxis = new long[3][length];

		// Iterate sizes by powers of 10
		for (int size = initialSize, i = 0; size <= finalSize; size *= 10, i++) {
			// Measure the time for all three search methods
			long[] totalTimes = measureSearchTime(size, low, high, repeat);

			// Report total times (across 'repeat' runs) for clarity
			System.out.printf("When size = %d, total time used = %s%n", size, Arrays.toString(totalTimes));

			// Store size on the x-axis
			xAxis[i] = size;
			// Convert total time to average time for each method
			for (int j = 0; j < totalTimes.length; j++) {
				yAxis[j][i] = totalTimes[j] / repeat;
			}
		}

		// Print summary of average times
		printSummary(xAxis, yAxis);

		// Draw the chart
		drawChart(xAxis, yAxis);
	}

	/**
	 * Measures the execution time of three different search methods: linear, iterative binary, and
	 * recursive binary. Each method is tested repeatedly with newly generated arrays and random targets.
	 *
	 * @param size   The size of the randomly generated arrays
	 * @param low    The lowest integer value in the array
	 * @param high   The highest integer value in the array
	 * @param repeat Number of repetitions for timing
	 * @return An array of total execution times (in nanoseconds) for each method:
	 *         [0] = linear search, [1] = iterative binary, [2] = recursive binary
	 */
	private static long[] measureSearchTime(int size, int low, int high, int repeat) {
		long[] totalTimes = new long[3]; // [0]=linear, [1]=iterBinary, [2]=recBinary

		for (int i = 0; i < repeat; i++) {
			// Generate a new random array and a random target to search for
			int[] arr = RANDOM.ints(size, low, high).toArray();
			int target = RANDOM.nextInt(high - low + 1) + low;

			// Time linear search
			totalTimes[0] += measure(() -> Searching.linearSearch(arr, target));

			// Time iterative binary search (note: typically requires a sorted array)
			totalTimes[1] += measure(() -> Searching.binarySearchIterative(arr, target));

			// Time recursive binary search (also typically requires sorting)
			totalTimes[2] += measure(() -> Searching.binarySearchRecursive(arr, 0, arr.length - 1, target));
		}

		return totalTimes;
	}

	/**
	 * A small utility to measure execution time of a Runnable in nanoseconds.
	 *
	 * @param task The code block to measure
	 * @return The execution time in nanoseconds
	 */
	private static long measure(Runnable task) {
		long start = System.nanoTime();
		task.run();
		return System.nanoTime() - start;
	}

	/**
	 * Prints a summary of the average times of all search methods in a structured format.
	 *
	 * @param xAxis Array sizes
	 * @param yAxis Search times for each size. [methodIndex][sizeIndex]
	 */
	private static void printSummary(int[] xAxis, long[][] yAxis) {
		System.out.println("\nThe average time used (in increasing size):");
		System.out.printf("  %-25s = %s%n", "Size", Arrays.toString(xAxis));
		System.out.printf("  %-25s = %s%n", "Linear Search", Arrays.toString(yAxis[0]));
		System.out.printf("  %-25s = %s%n", "Recursive Binary Search", Arrays.toString(yAxis[2]));
		System.out.printf("  %-25s = %s%n", "Iterative Binary Search", Arrays.toString(yAxis[1]));
	}

	/**
	 * Passes the search times and sizes to a GraphDrawer for rendering a line chart.
	 *
	 * @param xAxis Array sizes
	 * @param yAxis Search times for each size. [methodIndex][sizeIndex]
	 */
	private static void drawChart(int[] xAxis, long[][] yAxis) {
		String[] seriesNames = {
			"Linear Search",
			"Binary Search (Iteratively)",
			"Binary Search (Recursively)"
		};
		GraphDrawer drawer = new GraphDrawer(
			"Line Chart",
			"Comparison between different searching algorithms",
			"Size of the array",
			"Time used for searching",
			seriesNames,
			xAxis,
			yAxis,
			xAxis.length,
			seriesNames.length
		);
		drawer.draw();
	}
}
