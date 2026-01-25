package com.umwia1002.solution.pastyear.py2017s2.Q2;

import java.util.ArrayList;
public class GenericStack<E> implements StackInterface<E>{
    private final ArrayList<E> list;

    public GenericStack() {
        this.list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek() {
        return isEmpty() ? null : list.get(size() - 1);
    }

    @Override
    public E pop() {
        return isEmpty() ? null : list.remove(size() - 1);
    }

    @Override
    public void push(E item) {
        list.add(item);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size(); i++) {
            sb.append(list.get(i));
            if(i < size() - 1) {
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }
}
