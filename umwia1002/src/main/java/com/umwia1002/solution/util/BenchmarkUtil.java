package com.umwia1002.solution.util;

public class BenchmarkUtil {

    public static void benchmarkFunction(String functionName,
                                         long iterations,
                                         Runnable functionToTest) {
        long maxExecutionTime = getMaxExecutionTime(functionToTest, iterations);
        System.out.printf("Execution time for %s: %s ns%n", functionName, maxExecutionTime);
    }

    public static long getMaxExecutionTime(Runnable function, long iterations) {
        long longestExecutionTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            function.run();
            long executionTime = System.nanoTime() - startTime;
            if (executionTime > longestExecutionTime) {
                longestExecutionTime = executionTime;
            }
        }
        return longestExecutionTime;
    }
}
