package com.umwia1002.solution.lab.version1.lab05.l5q3;

public class Tester {

    public static void main(String[] args) {
        // 1. Adding 1, 10 and 100
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 1; i <= 100; i *= 10) {
            System.out.println("adding: " + i);
            list.addLast(i);
        }

        // 2. Adding 2
        System.out.println("adding: 2");
        list.add(2, 2);

        // 3. Removing an item
        System.out.println("deleted: " + list.remove(3));

        // 4. Iterating forward and backward
        System.out.println("\niterating forward..");
        list.iterateForward();
        System.out.println("\niterating backward..");
        list.iterateBackward();

        // 5. Clearing the list
        int size = list.getSize();
        System.out.println("size of current Doubly Linked List: " + size);
        list.clear();
        System.out.printf("Successfully clear %s node(s)%n", size);
        System.out.println("\nsize of current Doubly Linked List: " + list.getSize());
    }
}
