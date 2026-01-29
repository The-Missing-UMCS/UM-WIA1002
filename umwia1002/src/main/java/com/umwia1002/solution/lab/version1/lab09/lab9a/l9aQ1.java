package com.umwia1002.solution.lab.version1.lab09.lab9a;

import com.umwia1002.solution.util.BenchmarkUtil;

public class l9aQ1 {

    public static void main(String[] args) {
        // 1. Validate the output of the following method calls
        System.out.println("Result of substitute: " + substitute("flabbergasted"));
        System.out.println("Result of substituteAI: " + substituteAI("Astronaut"));

        System.out.println();

        // 2. Measure the time taken to execute the following method calls
        BenchmarkUtil.benchmarkFunction("substitute", 100_000, () -> substitute("flabbergasted"));
        BenchmarkUtil.benchmarkFunction("substituteAI", 100_000,
            () -> substituteAI("flabbergasted"));
    }

    public static String substitute(String str) {
        int occ = str.indexOf('a');
        boolean noMoreA = occ == -1;
        if (noMoreA) {
            return str;
        }
        return str.substring(0, occ) + 'i' + substitute(str.substring(occ + 1));
    }

    public static String substituteAI(String input) {
        if (input.isEmpty()) {
            return input;
        }
        char first = input.charAt(0);

        if (first == 'a') {
            first = 'i';
        }
        return first + substituteAI(input.substring(1));
    }
}
