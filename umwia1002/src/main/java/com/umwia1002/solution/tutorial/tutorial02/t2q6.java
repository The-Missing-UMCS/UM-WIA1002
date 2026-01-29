package com.umwia1002.solution.tutorial.tutorial02;

public class t2q6 {

    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo<>("Square", 4);
        Duo<Double, Double> points = new Duo<>(4.0, 4d);
    }

    static class Duo<A, B> {

        A first;
        B second;

        Duo(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
}
