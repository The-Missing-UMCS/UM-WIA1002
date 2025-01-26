package com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util;

import java.util.Stack;

public class UnmodifiableStack<E> extends Stack<E> {
    private final Stack<E> wrapped;

    public UnmodifiableStack(Stack<E> stack) {
        this.wrapped = stack;
    }

    @Override
    public E push(E item) {
        throw new UnsupportedOperationException("Cannot modify an unmodifiable stacks.");
    }

    @Override
    public synchronized E pop() {
        throw new UnsupportedOperationException("Cannot modify an unmodifiable stacks.");
    }

    @Override
    public synchronized E peek() {
        return wrapped.peek();
    }

    @Override
    public synchronized boolean empty() {
        return wrapped.empty();
    }

    @Override
    public synchronized int search(Object o) {
        return wrapped.search(o);
    }

    @Override
    public synchronized int size() {
        return wrapped.size();
    }

    @Override
    public synchronized boolean add(E e) {
        throw new UnsupportedOperationException("Cannot modify an unmodifiable stacks.");
    }

    @Override
    public synchronized E get(int index) {
        return wrapped.get(index);
    }

    @Override
    public synchronized E remove(int index) {
        throw new UnsupportedOperationException("Cannot modify an unmodifiable stacks.");
    }

    @Override
    public synchronized void clear() {
        throw new UnsupportedOperationException("Cannot modify an unmodifiable stacks.");
    }
}

