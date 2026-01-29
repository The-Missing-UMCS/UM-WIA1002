package com.umwia1002.solution.lab.version1.lab09.lab9b;

import com.umwia1002.solution.util.BenchmarkUtil;
import com.umwia1002.solution.util.InputUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.umwia1002.solution.util.ConsoleUtil.logInfo;

public class l9bQ3 {

    static int count = 0;

    public static void main(String[] args) {

        List<Method> methods = Arrays.asList(
            new Method("Counter", (n) -> {
                count = 0;
                hanoi(n, "A", "C", "B");
                return (long) count;
            }),
            new Method("Formula", l9bQ3::countUsingFormula),
            new Method("Recursively 1", l9bQ3::countRecursively1),
            new Method("Recursively 2", l9bQ3::countRecursively2),
            new Method("Custom T function", l9bQ3::countUsingFunction)
        );

        while (true) {
            count = 0;

            String input = InputUtil.getStringInput("Enter the value of discs (or 'q' to quit): ");

            if (input.toLowerCase().startsWith("q")) {
                break;
            }

            int n = Integer.parseInt(input);

            // 1. Validate the output of the following method calls
            logInfo("Validate the output (discs: %d)".formatted(n));
            methods.forEach(method -> {
                long steps = method.func.apply(n);
                System.out.printf("  - Steps taken (%s): %d%n", method.label, steps);
            });
            System.out.println();

            // 2. Measure the time taken to execute the following method calls
            logInfo("Benchmark Comparison (discs: %d)".formatted(n));
            methods.forEach(method -> {
                System.out.print("  - ");
                BenchmarkUtil.benchmarkFunction(method.label(), 10_000, () -> method.func.apply(n));
            });
            System.out.println();
        }
    }

    private static void hanoi(int disc, String src, String dst, String mid) {
        if (disc < 1) {
            System.out.println("Invalid");
        } else if (disc == 1) {
            count++;
        } else {
            hanoi(disc - 1, src, mid, dst);
            hanoi(disc - 1, mid, dst, src);
            count++;
        }
    }

    private static long countUsingFormula(int numOfDisc) {
        return (numOfDisc < 1) ? 0 : (long) Math.pow(2, numOfDisc) - 1;
    }

    private static long countRecursively1(int numOfDisc) {
        if (numOfDisc == 1) {
            return 1;
        }
        return 2 * countRecursively1(numOfDisc - 1) + 1;
    }

    private static long countRecursively2(int discNumber) {
        if (discNumber == 1) {
            return 1;
        }
        return (int) Math.pow(2, discNumber - 1) + countRecursively2(discNumber - 1);
    }

    private static long countUsingFunction(int numOfDisc) {
        if (numOfDisc == 1) {
            return 1;
        }

        long sum = numOfDisc;

        for (int i = 1; i < numOfDisc; i++) {
            sum += countUsingFunction(numOfDisc - i);
        }

        return sum;
    }

    record Method(
        String label,
        Function<Integer, Long> func
    ) {

    }
}
