package com.umwia1002.solution.tutorial.tutorial09;

public class t9q4 {

    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    public static int sum(int N) {
        // Triangular Number
        if (N <= 1) {
            return 1;
        } else {
            return N + sum(N - 1);
        }
    }
}
