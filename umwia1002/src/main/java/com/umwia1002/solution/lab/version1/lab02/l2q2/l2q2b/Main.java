package com.umwia1002.solution.lab.version1.lab02.l2q2.l2q2b;

public class Main {

    public static void main(String[] args) {
        MyGeneric<String> strGeneric = new MyGeneric<>("Hello World");
        MyGeneric<Integer> intGeneric = new MyGeneric<>(12345);
        System.out.println("strGeneric: " + strGeneric.getObject());
        System.out.println("intGeneric: " + intGeneric.getObject());
    }
}
