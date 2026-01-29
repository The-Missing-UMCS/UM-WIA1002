package com.umwia1002.solution.lab.version1.lab06.l6q5.elementary;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util.UnmodifiableStack;

import java.util.Iterator;
import java.util.Stack;

public class IntStack {

    Stack<Integer> stack;

    public IntStack() {
        stack = new Stack<>();
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public void push(int i) {
        stack.push(i);
    }

    public Iterator<Integer> iterator() {
        return stack.iterator();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public Stack<Integer> stacks() {
        return new UnmodifiableStack<>(stack);
    }
}
