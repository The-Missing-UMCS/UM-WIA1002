package com.umwia1002.solution.tutorial.tutorial5;

public class T5Q1 {
	public static void main(String[] args) {
		// a) Set the old element at the (index)th node to e and return the old element
		// b) Set the element at (index)th node to e
		// c)
	}
}

class LinkedList<E>{
	static class Node<E>{
		E item;
		Node<E> next;
		
		Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}
	
	Node<E> head;
	Node<E> tail;
	int size;
	
	public E set(int index, E e) {
		if(index < 0 || index > size) {
			return null;
		} else if (index == size){
			addLast(e);
			return null;
		} else {
			Node<E> node = head;
			for(int i = 0; i < index; i++) 
				node = node.next;
			E oldVal = node.item;
			node.item = e;
			return oldVal;
		}
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e, null);
		if(head == null)
			head = newNode;
		else 
			tail.next = newNode;
		tail = newNode;
		size++;
	}
}
