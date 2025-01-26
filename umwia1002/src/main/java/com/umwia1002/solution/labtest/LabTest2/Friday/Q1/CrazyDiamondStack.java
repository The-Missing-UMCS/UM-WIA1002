package com.umwia1002.solution.labtest.LabTest2.Friday.Q1;

public class CrazyDiamondStack<CD> {
    private final TheHandStack<CD> stack1 = new TheHandStack<>();
    private final TheHandStack<CD> stack2 = new TheHandStack<>();

    public void push(CD o) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        stack1.push(o);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public CD pop() {
        return stack1.pop();
    }

    public CD peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int size() {
        return stack1.size();
    }

    @Override
    public String toString() {
        return stack1.toString();
    }

}
