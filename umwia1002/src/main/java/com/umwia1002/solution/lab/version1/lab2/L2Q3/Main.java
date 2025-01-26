package com.umwia1002.solution.lab.version1.lab2.L2Q3;

import static com.umwia1002.solution.util.BenchmarkUtil.benchmarkFunction;

public class Main {

    public static void main(String[] args) {
        runTestCase("a", "b", "c");
        runTestCase(4, 5, 6);
    }

    private static <T extends Comparable<T>> void runTestCase(T a, T b, T c) {
        long iterations = 100_000L;
        System.out.printf("Running test case with inputs: [%s, %s, %s]\n", a, b, c);

        benchmarkFunction("maximal", iterations, () -> CompareMax.maximal(a, b, c));
        benchmarkFunction("max", iterations, () -> CompareMax.max(a, b, c));
        benchmarkFunction("maximum", iterations, () -> CompareMax.maximum(a, b, c));
    }
}
