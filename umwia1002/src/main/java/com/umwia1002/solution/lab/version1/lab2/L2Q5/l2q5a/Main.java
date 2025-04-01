package com.umwia1002.solution.lab.version1.lab2.L2Q5.l2q5a;

public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"red", "green", "blue"};
        Circle[] cirArr = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println(FindMax.max(intArr));
        System.out.println(FindMax.max(strArr));
        System.out.println(FindMax.max(cirArr));
    }
}
