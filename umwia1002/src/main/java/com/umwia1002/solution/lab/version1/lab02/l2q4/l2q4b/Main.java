package com.umwia1002.solution.lab.version1.lab02.l2q4.l2q4b;

import com.umwia1002.solution.util.BenchmarkUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Visualization
        MinMaxResult<Integer> intResult = MinMax.minmax(new Integer[]{5, 3, 7, 1, 4, 9, 8, 2});
        MinMaxResult<String> strResult = MinMax.minmax(
            new String[]{"red", "blue", "orange", "tan"});
        System.out.printf("(INT) Min: %d, Max: %d\n", intResult.min(), intResult.max());
        System.out.printf("(STR) Min: %s, Max: %s\n", strResult.min(), strResult.max());

        // Benchmark
        runTestCases(new Integer[]{5, 3, 7, 1, 4, 9, 8, 2});
        runTestCases(new String[]{"red", "blue", "orange", "tan"});
    }

    private static <T extends Comparable<T>> void runTestCases(T[] testcases) {
        System.out.println("Test case: " + Arrays.toString(testcases));
        BenchmarkUtil.benchmarkFunction("Stream minmax", 100_000L, () -> MinMax.minMax(testcases));
        BenchmarkUtil.benchmarkFunction("minmax", 100_000L, () -> MinMax.minmax(testcases));
    }
}
