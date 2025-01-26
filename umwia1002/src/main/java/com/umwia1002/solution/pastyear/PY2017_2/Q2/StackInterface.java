package com.umwia1002.solution.pastyear.PY2017_2.Q2;

public interface StackInterface<E> {
    /**
     * Returns the number of element in this stacks
     * @return the number of element in this stacks
     */
    public int size();

    /**
     * Returns the top element in this stacks
     * @return the top element in this stacks
     */
    public E peek();

    /**
     * Returns and removes the top element in this stacks
     * @return the top element in this stacks
     */
    public E pop();

    /**
     * Adds a new element to the top of this stacks
     * @param e
     */
    public void push(E e);

    /**
     * Returns true if the stacks is empty, false otherwise.
     * @return true if the stacks is empty, false otherwise.
     */
    public boolean isEmpty();
}