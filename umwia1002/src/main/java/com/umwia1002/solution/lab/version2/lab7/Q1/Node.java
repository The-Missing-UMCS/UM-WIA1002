package com.umwia1002.solution.lab.version2.lab7.Q1;

public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
	E item;
	int occ;
	Node<E> left;
	Node<E> right;

	Node(E item) {
		this.occ = 1;
		this.item = item;
	}
	
	@Override
	public int compareTo(Node<E> o) {
		return item.compareTo(o.item);
	}
}
