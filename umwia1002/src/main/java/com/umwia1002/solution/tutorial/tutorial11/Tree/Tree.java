package com.umwia1002.solution.tutorial.tutorial11.Tree;

public interface Tree<E extends Comparable<E>> {

    int height();

    boolean add(E item);

    void preOrder();

    void inOrder();

    void postOrder();

    boolean delete(E item);

    boolean contains(E item);

    int getSize();

    void showTree();

    void clear();

}
