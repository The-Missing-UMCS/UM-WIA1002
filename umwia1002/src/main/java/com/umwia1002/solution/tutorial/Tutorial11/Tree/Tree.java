package com.umwia1002.solution.tutorial.Tutorial11.Tree;

public interface Tree<E extends Comparable<E>> {
	public int height();
	public boolean add(E item);
	public void preOrder();
	public void inOrder();
	public void postOrder();
	public boolean delete(E item);
	public boolean contains(E item);
	public int getSize();
	public void showTree();
	public void clear();
}
