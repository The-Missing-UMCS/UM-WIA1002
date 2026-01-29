package com.umwia1002.solution.lab.version1.lab06.l6q1;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E> {

    private final ArrayList<E> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(E element) {
        stack.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeLast();
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getLast();
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public boolean search(E element) {
        return stack.contains(element);
    }
}
