package com.umwia1002.solution.tutorial.Tutorial11.Tree;

public class BST<E extends Comparable<E>> implements Tree<E> {
	int size;
	TreeNode<E> root;
	
	public int height() {
		return height(root);
	}
	
	private int height(TreeNode<E> node) {
		if(node == null) 
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public boolean add(E item) {
		if(root == null) {
			root = new TreeNode<E>(item);
		} else {
			TreeNode<E> parent = root; int value = 0;
			for(TreeNode<E> curr = root; curr != null; ) {
				value = item.compareTo(curr.item);
				if(value == 0)
					return false;
				parent = curr;
				curr = value > 0 ? curr.right : curr.left;
			}
			
			if(value > 0)
				parent.right = new TreeNode<E>(item);
			else
				parent.left = new TreeNode<E>(item);
		}
		
		size++;
		return true;
	}
	
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	
	private void preOrder(TreeNode<E> node) {
		if(node != null) {
			System.out.print(node.item + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	
	private void inOrder(TreeNode<E> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.item + " ");
			inOrder(node.right);
		}
	}
	
	public void postOrder() {
		postOrder(root);
		System.out.println();
	}
	
	private void postOrder(TreeNode<E> node) {
		if(node != null) {
			postOrder(node.right);
			postOrder(node.left);
			System.out.print(node.item + " ");
		}
	}
	
	public boolean delete(E item) {
		TreeNode<E> parent = null;
		TreeNode<E> curr = root;
		
		while(curr != null) {
			int val = item.compareTo(curr.item);
			if(val == 0)
				break;
			parent = curr;
			curr = val > 0 ? curr.right : curr.left;
		}
		
		if(curr == null)
			return false;
		
		if(curr.left == null) {
			if(parent == null)
				root = curr.right;
			else if(curr.compareTo(parent.left) == 0)
				parent.left = curr.right;
			else
				parent.right = curr.right;
			
		} else {
			TreeNode<E> rightMost = curr.left;
			TreeNode<E> parentOfRightMost = curr;
			
			while(rightMost.right != null){
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			
			curr.item = rightMost.item;
			
			if(parentOfRightMost.left.compareTo(rightMost) == 0)
				parentOfRightMost.left = rightMost.left;
			else
				parentOfRightMost.right = rightMost.right;
		}
		
		size--;
		return true;
	}
	
	public boolean contains(E item) {
		return treeNode(item) == null ? false : true; 
	}
	
	TreeNode<E> treeNode(E item) {
		for(TreeNode<E> node = root; node != null; ) {
			int value = item.compareTo(node.item);
			if(value == 0)
				return node;
			node = value > 0 ? node.right : node.left;
		}
		return null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void showTree() {
//		TreePrinter.print(this);
		TreePrinter.printBinaryTree(root, 0);
//		TreePrinter.print("", root, false);
	}
	
	public void clear() {
		clear(root);
		size = 0;
	}
	
	private void clear(TreeNode<E> node) {
		if(node != null) {
			clear(node.left);
			clear(node.right);
			node.item = null;
			node.left = node.right = null;
		}
	}

}
