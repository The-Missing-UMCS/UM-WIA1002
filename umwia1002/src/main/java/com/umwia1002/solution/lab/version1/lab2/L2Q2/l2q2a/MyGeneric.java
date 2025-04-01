package com.umwia1002.solution.lab.version1.lab2.L2Q2.l2q2a;

public class MyGeneric<E> {
    private E object;

    public MyGeneric() {

    }

    public MyGeneric(E object) {
        this.object = object;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }
}
