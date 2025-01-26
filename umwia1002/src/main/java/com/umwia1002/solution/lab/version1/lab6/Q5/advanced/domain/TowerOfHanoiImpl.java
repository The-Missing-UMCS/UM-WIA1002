package com.umwia1002.solution.lab.version1.lab6.Q5.advanced.domain;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util.UnmodifiableStack;

import java.util.Stack;

public class TowerOfHanoiImpl implements TowerOfHanoi {
    public static final String ROD_LABELS = "abc";
    public static final int DEFAULT_NUM_OF_DISCS = 3;
    private static final int NUM_OF_ROD = 3;

    protected final Stack<Integer>[] stacks;

    protected final int numOfDiscs;

    public TowerOfHanoiImpl() {
        this(DEFAULT_NUM_OF_DISCS);
    }

    @SuppressWarnings("unchecked")
    public TowerOfHanoiImpl(int numOfDiscs) {
        this.numOfDiscs = numOfDiscs;
        this.stacks = new Stack[NUM_OF_ROD];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = numOfDiscs; i > 0; i--) {
            stacks[0].push(i);
        }
    }

    @Override
    public int peek(int rod) {
        return peek(stacks[rod]);
    }

    public int peek(Stack<Integer> stack) {
        return stack.peek();
    }

    @Override
    public int makeMove(int src, int dst) {
        return makeMove(stacks[src], stacks[dst]);
    }

    public int makeMove(Stack<Integer> src, Stack<Integer> dst) {
        int disc = src.pop();
        dst.push(disc);
        return disc;
    }

    @Override
    public boolean isValidMove(int src, int dst) {
        if (src < 0 || src >= NUM_OF_ROD || dst < 0 || dst >= NUM_OF_ROD) {
            return false;
        }
        return isValidMove(stacks[src], stacks[dst]);
    }

    public boolean isValidMove(Stack<Integer> src, Stack<Integer> dst) {
        // If source is empty, nothing can be popped, thus return false;
        // If destination is empty, any value from source can be popped.
        // If both source and destination are not empty,
        // thus the src.peek() should be smaller than dst.peek()
        return !src.isEmpty() && (dst.isEmpty() || src.peek() < dst.peek());
    }

    @Override
    public boolean isFinished() {
        return stacks[NUM_OF_ROD - 1].size() == numOfDiscs;
    }

    @Override
    public int getNumOfDiscs() {
        return numOfDiscs;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stack<Integer>[] getStacks() {
        Stack<Integer>[] unmodifiableStacks = new Stack[stacks.length];
        for (int i = 0; i < stacks.length; i++) {
            Stack<Integer> stackCopy = new Stack<>();
            stackCopy.addAll(stacks[i]);

            // Wrap the stacks copy in an unmodifiable version
            unmodifiableStacks[i] = new UnmodifiableStack<>(stackCopy);
        }
        return unmodifiableStacks;
    }
}
