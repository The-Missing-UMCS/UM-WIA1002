package com.umwia1002.solution.pastyear.py2019s2.Q1;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {2, 10, 38, 41, 51};
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        for (int val : arr1) {
            list1.addLast(val);
        }
        System.out.println(list1);

        int[] arr2 = {5, 12, 18, 21, 35, 41, 56};
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        for (int val : arr2) {
            list2.addLast(val);
        }
        System.out.println(list2);

        MyLinkedList<Integer> newList = combine(list1, list2);
        System.out.println(newList);
    }

    public static <E extends Comparable<E>> MyLinkedList<E> combine(MyLinkedList<E> one, MyLinkedList<E> two) {
        E elemOne = one.removeFirst();
        E elemTwo = two.removeFirst();
        MyLinkedList<E> newList = new MyLinkedList<>();

        while (elemOne != null && elemTwo != null) {
            if (elemOne.compareTo(elemTwo) < 0) {
                newList.addLast(elemOne);
                elemOne = one.removeFirst();
            } else {
                newList.addLast(elemTwo);
                elemTwo = two.removeFirst();
            }
        }

        while (elemOne != null) {
            newList.addLast(elemOne);
            elemOne = one.removeFirst();
        }

        while (elemTwo != null) {
            newList.addLast(elemTwo);
            elemTwo = two.removeFirst();
        }

        return newList;
    }
}