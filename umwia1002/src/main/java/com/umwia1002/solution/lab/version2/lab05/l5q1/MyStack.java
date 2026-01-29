package com.umwia1002.solution.lab.version2.lab05.l5q1;

import java.util.LinkedList;

public class MyStack<E> {

    private final LinkedList<E> list;

    MyStack() {
        list = new LinkedList<>();
    }

    public void push(E elem) {
        list.addFirst(elem);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }

    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : list) {
            sb.append(" <-- ").append(e);
        }
        return sb.toString();
    }
}
