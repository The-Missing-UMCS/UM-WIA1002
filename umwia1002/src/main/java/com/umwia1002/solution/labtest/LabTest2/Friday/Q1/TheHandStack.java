package com.umwia1002.solution.labtest.LabTest2.Friday.Q1;

import java.util.ArrayList;

public final class TheHandStack<TH> {
    private final ArrayList<TH> stack = new ArrayList<>();

    public void push(TH element) {
        stack.add(element);
    }

    public TH pop() {
        return stack.isEmpty() ? null : stack.remove(0);
    }

    public TH peek() {
        return stack.isEmpty() ? null : stack.get(0);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
