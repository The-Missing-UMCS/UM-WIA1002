package com.umwia1002.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        print();
    }

    public static void print() {
        var students = List.of(
            new Student("student-1", "matricNo-1"),
            new Student("student-2", "matricNo-2")
        );

        for (var student : students) {
            System.out.println(student);
        }
    }

    record Student(
        String name,
        String matricNo
    ) {

    }
}