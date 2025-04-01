package com.umwia1002.solution.lab.version1.lab2.L2Q2.l2q2a;

public class Main {
    public static void main(String[] args) {
        MyGeneric<String> strGeneric = new MyGeneric<>("Hello World");
        MyGeneric<Integer> intGeneric = new MyGeneric<>(12345);
        System.out.println("strGeneric: " + strGeneric.getObject());
        System.out.println("intGeneric: " + intGeneric.getObject());
    }
}
