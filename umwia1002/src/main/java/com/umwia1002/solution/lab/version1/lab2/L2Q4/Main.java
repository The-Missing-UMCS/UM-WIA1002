package com.umwia1002.solution.lab.version1.lab2.L2Q4;

import com.umwia1002.solution.util.BenchmarkUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        runTestCases(new Integer[]{5, 3, 7, 1, 4, 9, 8, 2});
        runTestCases(new String[]{"red", "blue", "orange", "tan"});
    }

    private static <T extends Comparable<T>> void runTestCases(T[] testcases) {
        System.out.println("Test case: " + Arrays.toString(testcases));
        BenchmarkUtil.benchmarkFunction("Stream minmax", 100_000L, () -> Tools.minMax(testcases));
        BenchmarkUtil.benchmarkFunction("minmax", 100_000L, () -> Tools.minmax(testcases));
    }
}
