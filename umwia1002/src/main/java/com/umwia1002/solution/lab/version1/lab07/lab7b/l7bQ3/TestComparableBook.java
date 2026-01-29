package com.umwia1002.solution.lab.version1.lab07.lab7b.l7bQ3;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestComparableBook {

    public static void main(String[] args) {
        Queue<ComparableBook> bookQueue = getBookQueue();
        System.out.println(bookQueue);

        while (!bookQueue.isEmpty()) {
            System.out.println("Head Element: " + bookQueue.peek());
            bookQueue.remove();
            System.out.println("Priority queue: " + bookQueue);
            System.out.println();
        }
    }

    private static Queue<ComparableBook> getBookQueue() {
        Queue<ComparableBook> bookQueue = new PriorityQueue<>();
        bookQueue.add(new ComparableBook(1065, "Effective Java: Third Edition"));
        bookQueue.add(new ComparableBook(3012, "Java: A Beginner Guide Seventh Edition"));
        bookQueue.add(new ComparableBook(1097, "Learn Java in One Day and Learn It Well"));
        bookQueue.add(new ComparableBook(7063, "Beginning Programming with Java (Dummies)"));
        bookQueue.add(new ComparableBook(6481, "Java: Programming Basic for Absolute Beginner"));
        return bookQueue;
    }
}
