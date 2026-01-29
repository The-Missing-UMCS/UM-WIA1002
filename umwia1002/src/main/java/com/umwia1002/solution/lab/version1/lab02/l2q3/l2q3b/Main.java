package com.umwia1002.solution.lab.version1.lab02.l2q3.l2q3b;

import static com.umwia1002.solution.util.BenchmarkUtil.benchmarkFunction;

public class Main {

    public static void main(String[] args) {
        runTestCase(1, 2, 3);
        runTestCase("C", "B", "A");
    }

    private static <T extends Comparable<T>> void runTestCase(T a, T b, T c) {
        long iterations = 100_000L;
        System.out.printf("Running test case with inputs: [%s, %s, %s]\n", a, b, c);

        benchmarkFunction("comparison1", iterations, () -> CompareMax.maxUsingComparison1(a, b, c));
        benchmarkFunction("comparison2", iterations, () -> CompareMax.maxUsingComparison2(a, b, c));
        benchmarkFunction("stream", iterations, () -> CompareMax.maxUsingStream(a, b, c));

        System.out.println();
    }
}
