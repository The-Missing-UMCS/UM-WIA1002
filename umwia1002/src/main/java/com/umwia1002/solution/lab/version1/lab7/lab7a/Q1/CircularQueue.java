package com.umwia1002.solution.lab.version1.lab7.lab7a.Q1;

public class CircularQueue<E> {
    private E[] data;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        data = (E[]) new Object[capacity];
        head = -1;
        tail = -1;
        size = 0;
    }

    public boolean offer(E item) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % data.length;
        data[tail] = item;
        size++;
        return true;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E removedItem = data[head];
        data[head] = null;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % data.length;
        }
        size--;
        return removedItem;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data[head];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
