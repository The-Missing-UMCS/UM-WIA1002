package com.umwia1002.solution.lab.version2.lab02.l2q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final int N = 20;
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 200;

    public static void main(String[] args) {
        System.out.printf("Generate %d non-duplicate integers within %d-%d%n", N, LOWER_BOUND,
            UPPER_BOUND);

        System.out.println("ArrayList Implementation:");
        ArrayList<Integer> arrayListResult = generateNonDuplicates(new ArrayList<>());
        printResult(arrayListResult);

        System.out.println();

        System.out.println("LinkedList Implementation:");
        LinkedList<Integer> linkedListResult = generateNonDuplicates(new LinkedList<>());
        printResult(linkedListResult);
    }

    private static <T extends List<Integer>> T generateNonDuplicates(T list) {
        NonDuplicate<T> generator = new NonDuplicate<>(list, LOWER_BOUND, UPPER_BOUND);
        return generator.generate(N);
    }

    private static void printResult(Iterable<Integer> list) {
        list.forEach(val -> System.out.print(val + " "));
        System.out.println();
    }
}
