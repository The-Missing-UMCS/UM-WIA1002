package com.umwia1002.solution.lab.version2.lab02.l2q2;

import java.util.Arrays;

public class TextFileLog<T> implements SimpleLog<T> {

    private static final int DEFAULT_MAX_SIZE = 5;
    private final int maxSize;
    private int size = 0;
    private final T[] log;

    public TextFileLog() {
        this(DEFAULT_MAX_SIZE);
    }

    @SuppressWarnings("unchecked")
    public TextFileLog(int maxSize) {
        this.maxSize = maxSize;
        this.log = (T[]) new Object[maxSize];
    }

    @Override
    public boolean insert(T item) {
        if (!isFull()) {
            log[size++] = item;
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    @Override
    public boolean delete(T item) {
        int index = indexOf(item);
        if (index >= 0) {
            System.arraycopy(log, index + 1, log, index, size - index - 1);
            log[--size] = null;
            return true;
        }
        return false;
    }

    @Override
    public void display() {
        Arrays.stream(log, 0, size).forEach(System.out::println);
    }

    @Override
    public void clear() {
        Arrays.fill(log, 0, size, null);
        size = 0;
    }

    public int indexOf(T item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (log[i] == item) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(log[i])) {
                    return i;
                }
            }
        }

        return -1;
    }
}
