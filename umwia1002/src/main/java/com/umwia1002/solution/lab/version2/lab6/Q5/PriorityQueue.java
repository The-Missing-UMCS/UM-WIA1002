package com.umwia1002.solution.lab.version2.lab6.Q5;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> {
	int size;
	Node<E> head;
	Node<E> tail;

	static class Node<E extends Comparable<E>> {
		E item;
		Node<E> prev;
		Node<E> next;

		Node(Node<E> prev, E item, Node<E> next) {
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
	}

	public E peek() {
		if (head == null)
			throw new NoSuchElementException();
		return head.item;
	}

	public E remove() {
		E item = head.item;
		head = head.next;
		head.prev = null;
		size--;
		return item;
	}

	public void add(E e) {
		if(e == null)
			throw new NullPointerException();
		
		if(head == null) {
			addFirst(e);
		} else {
			Node<E> node;
			for(node = head; node != null; node = node.next) {
				if(e.compareTo(node.item) > 0) {
					linkBefore(e, node);
					break;
				}
			}
			if(node == null)
				addLast(e);
		}
	}
	
	void addFirst(E e) {
		Node<E> newNode = new Node<>(null, e, head);
		if(head == null) 
			tail = newNode;
		 else 
			head.prev = newNode;
		head = newNode;
		size++;
	}
	
	void addLast(E e) {
		Node<E> newNode = new Node<>(tail, e, null);
		if(tail == null)
			head = newNode;
		else 
			tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	void linkBefore(E item, Node<E> succ) {
		Node<E> pred = succ.prev;
		Node<E> newNode = new Node<>(pred, item, succ);
		if(pred == null)
			head = newNode;
		else 
			pred.next = newNode;
		succ.prev = newNode;
		size++;		
	}
	
	public void clear() {
		for(Node<E> node = head; node != null; ) {
			Node<E> succ = node.next;
			node.item = null;
			node.prev = node.next = null;
			node = succ;
		}
		head = tail = null;
	}

	public boolean contains(E e) {
		for(Node<E> node = head; node != null; node = node.next) 
			if(node.item.compareTo(e) == 0)
				return true;
		return false;
	}
	
	public int size() {
		return size;
	}
	
	Node<E> node(int index) {
		if(index < (size >> 1)) {
			Node<E> node = head;
			for(int i = 0; i < index; i++)
				node = node.next;
			return node;
		} else {
			Node<E> node = tail;
			for(int i = size; i > index; i--)
				node = node.next;
			return node;
		}
	}
	
	public Iterator<E> iterator(){
		return new QueueIterator(0);
	}
	
	public class QueueIterator implements Iterator<E> {
		int nextIndex;
		Node<E> lastReturned;
		Node<E> next;
		
		QueueIterator(int index) {
			this.nextIndex = index;
			this.next = node(index);
		}
		
		public boolean hasNext() {
			return nextIndex < size;
		}
		
		public E next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.item;
		}
	}
}
