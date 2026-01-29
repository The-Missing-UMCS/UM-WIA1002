package com.umwia1002.solution.tutorial.tutorial06.t6q2;

import java.util.Stack;

public class Simulator {

    private static final StackPrinter PRINTER = new StackPrinter();
    private static final Stack<String>[] STACKS = createStacks();

    public static void main(String[] args) {
        Stack<String> s1 = STACKS[0];
        Stack<String> s2 = STACKS[1];
        Stack<String> s3 = STACKS[2];
        printStack();

        s2.push(s1.pop());
        printStack();

        s3.push(s1.pop());
        printStack();

        s1.pop();
        printStack();

        s1.push(s2.pop());
        printStack();

        s2.push(s3.pop());
        printStack();

        s2.push(s1.pop());
        printStack();
    }

    private static Stack<String>[] createStacks() {
        @SuppressWarnings("unchecked")
        Stack<String>[] stacks = new Stack[]{new Stack<>(), new Stack<>(), new Stack<>()};
        stacks[0].push("zero");
        stacks[0].push("one");
        stacks[0].push("two");
        return stacks;
    }

    private static void printStack() {
        PRINTER.printStack(STACKS);
    }
}
