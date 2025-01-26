package com.umwia1002.solution.labtest.LabTest2.Wednesday.Q1;

@SuppressWarnings("unchecked")
public class DIOStack<DIO> {
    private DIO[] array = (DIO[]) new Object[1];
    private int size = 0;

    public void push(DIO o) {
        if(size >= array.length) {
            resize(size << 1);
        }
        for(int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = o;
        size++;
    }

    public DIO pop() {
        if(isEmpty()) {
            return null;
        }

        DIO removed = array[0];
        for(int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removed;
    }

    public DIO peek() {
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for(int i = size - 1; i >= 0; i--) {
            sb.append(array[i]);
            if(i != 0) {
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }

    private void resize(int size) {
        DIO[] newArray = (DIO[]) new Object[size];
        System.arraycopy(array, 0, newArray, 0, this.size);
        this.array = null;
        this.array = newArray;
    }
}