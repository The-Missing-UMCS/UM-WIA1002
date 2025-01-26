package com.umwia1002.solution.tutorial.Tutorial11.Tree;

public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>>{
	E item;
	TreeNode<E> left;
	TreeNode<E> right;
	
	TreeNode(E item) {
		this.item = item;
	}
	
	@Override
	public int compareTo(TreeNode<E> o) {
		return item.compareTo(o.item);
	}
	
	@Override
	public String toString() {
		return item.toString();
	}
}
