package com.umwia1002.solution.lab.version1.lab04;

public class TestLinkedList {

    public static void main(String[] args) {
        MyLinkedList<Character> ls = new MyLinkedList<>();

        // a.
        for (char ch = 'a'; ch <= 'e'; ch++) {
            ls.addLast(ch);
        }

        // b.
        ls.print();

        // c.
        ls.reverse();

        // d.
        System.out.println("Number of elements: " + ls.size());

        // e.
        System.out.println("First value: " + ls.getFirst());
        System.out.println("Last value: " + ls.getLast());

        // f.
        System.out.println("Middle value: " + ls.getMiddleValue());
        ls.remove(ls.size() / 2);

        // g.
        System.out.printf("Second value = %c, Third value = %c\n", ls.get(1), ls.get(2));

        // h.
        System.out.println("LinkedList contains 'c' is " + ls.contains('c'));

        // i.
        char[] chars = "hello".toCharArray();

        int i = 0;
        for (; i < ls.size(); i++) {
            ls.set(i, chars[i]);
        }
        for (; i < chars.length; i++) {
            ls.addLast(chars[i]);
        }

        ls.print();
    }
}
