package com.umwia1002.solution.lab.version1.lab11;

public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>> {
	E elem;
	TreeNode<E> left;
	TreeNode<E> right;
	
	// internal vertices
	TreeNode(E elem, TreeNode<E> left, TreeNode<E> right) {
		this.elem = elem;
		this.left = left;
		this.right = right;
	}
	
	// leaves
	TreeNode(E elem){
		this(elem, null, null);
	}
	
	@Override
	public int compareTo(TreeNode<E> o) {
		return elem.compareTo(o.elem);
	}
	
}
