package com.umwia1002.solution.pastyear.PY2023_1.wia1002_2023_1.Q1;

import java.util.LinkedList;

public class ExamStack<E> {
    public LinkedList<E> stack;

    public ExamStack() {
        this.stack = new LinkedList<E>();
    }

    public E peep() {
        return stack.getFirst();
    }

    public E pop() {
        return stack.removeFirst();
    }

    public void push(E e) {
        stack.addFirst(e);
    }

    public int getSize() {
        return stack.size();
    }
}
