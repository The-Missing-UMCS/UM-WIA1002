package com.umwia1002.solution.lab.version2.lab7.Q1;

import java.util.ArrayList;

public class IntegerTree {
	BinarySearchTree<Integer> tree;

	IntegerTree() {
		this.tree = new BinarySearchTree<Integer>();
	}
	
	public void insert(int value) {
		tree.insert(value);
	}
	
	public boolean delete(int value) {
		return tree.delete(value);
	}
	
	public void inOrder() {
		tree.inOrder();
	}
	
	public void postOrder() {
		tree.postOrder();
	}
	
	public void preOrder() {
		tree.preOrder();
	}
	
	public void clear() {
		tree.clear();
	}
	
	public int minValue() {
		return tree.minValue();
	}
	
	public int maxValue() {
		return tree.maxValue();
	}
	
	public ArrayList<Node<Integer>> path(int value) {
		return tree.path(value);
	}
	
	public int getTotal() {
		return getTotal(tree.root);
	}
	
	public int getTotal(Node<Integer> node) {
		if(node == null)
			return 0;
		return node.item * node.occ + getTotal(node.left) + getTotal(node.right);
	}
	
	public int getRoot() {
		return tree.getRoot();
	}
	
	public int getSize() {
		return tree.getSize();
	}
	
	public int height() {
		return tree.height();
	}
	
	public int getOccurence(int value) {
		return tree.getOccurence(value);
	}
}
