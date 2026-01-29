package com.umwia1002.solution.tutorial.tutorial07.tutorial7a;


import java.util.LinkedList;
import java.util.Queue;

public class t7aQ4 {

    public static void main(String[] args) {
        Queue<Integer> X = new LinkedList<>();
        X.add(14);
        X.add(3);
        X.add(5);
        Object Y = X.poll();
        X.add(7);
        X.add(9);
        Y = X.poll();
        X.add(2);
        X.add(4);

        // a) X.front() = 5
        System.out.println("a) X.peek() = " + X.peek());

        // b) Y = 5, X.front() = 7
        Y = X.poll();
        X.add(10);
        System.out.println("b) Y = " + Y);
        System.out.println("b) X.peek() = " + X.peek());

        // c) Y = 7
        Y = X.poll();
        System.out.println("c) Y = " + Y);

        // d) X.front() = 9
        System.out.println("d) X.peek() = " + X.peek());
    }
}
