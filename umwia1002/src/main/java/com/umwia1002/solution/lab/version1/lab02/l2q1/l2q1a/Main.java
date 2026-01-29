package com.umwia1002.solution.lab.version1.lab02.l2q1.l2q1a;

public class Main {

    public static void main(String[] args) {
        StorePair a = new StorePair(6, 4);
        StorePair b = new StorePair(2, 2);
        StorePair c = new StorePair(6, 3);
        StorePair d = new StorePair(6, 4);

        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("a.compareTo(c) = " + a.compareTo(c));
        System.out.println("b.compareTo(c) = " + b.compareTo(c));

        System.out.println("a.equals(b) = " + a.equals(b));
        System.out.println("a.equals(c) = " + a.equals(c));
        System.out.println("b.equals(c) = " + b.equals(c));
        System.out.println("a.equals(d) = " + a.equals(d));
        System.out.println(a.hashCode());
        System.out.println(d.hashCode());
        System.out.println(a.equals(d)); // correct way to compare!
        System.out.println(a == d); // return false, incorrect way to compare!
    }
}
