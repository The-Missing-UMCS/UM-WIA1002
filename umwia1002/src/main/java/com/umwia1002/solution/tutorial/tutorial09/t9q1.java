package com.umwia1002.solution.tutorial.tutorial09;

public class t9q1 {

    public static void main(String[] args) {
        // StackOverflow error
        // There is no base case for n < 1
        f(0);
    }

    public static int f(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * f(n - 1);
        }
    }
}
