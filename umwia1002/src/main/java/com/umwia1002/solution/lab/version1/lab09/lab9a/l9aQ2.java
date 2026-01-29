package com.umwia1002.solution.lab.version1.lab09.lab9a;

import com.umwia1002.solution.util.BenchmarkUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class l9aQ2 {

    public static void main(String[] args) {
        // 1. Validate the output of the following method calls
        List<String> arr = permuteString("ABC");
        System.out.println(arr);

        Set<String> set = permuteStringSet("ABC");
        System.out.println(set);

        // 2. Measure the time taken to execute the following method calls
        BenchmarkUtil.benchmarkFunction("permuteString(String.class)", 100_000,
            () -> permuteString("ABC"));
        BenchmarkUtil.benchmarkFunction("permuteStringSet(String.class)", 100_000,
            () -> permuteStringSet("ABC"));
    }

    public static List<String> permuteString(String str) {
        if (str.length() == 1) {
            return List.of(str);
        }

        List<String> permutations = permuteString(str.substring(1));
        List<String> result = new ArrayList<>();

        for (String permutation : permutations) {
            for (int c = 0; c <= permutation.length(); c++) {
                result.add(permutation.substring(0, c) + str.charAt(0) + permutation.substring(c));
            }
        }

        return result;
    }

    /**
     * Generates all permutations of a string and returns them as a Set (for uniqueness).
     */
    public static Set<String> permuteStringSet(String str) {
        Set<String> result = new HashSet<>();
        permuteHelper("", str, result);
        return result;
    }

    /**
     * Helper method for generating permutations.
     * Works for both List and Set results using a generic collection.
     */
    private static void permuteHelper(String prefix, String str, Set<String> result) {
        if (str.isEmpty()) {
            result.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permuteHelper(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1),
                    result);
            }
        }
    }
}
