package com.umwia1002.solution.tutorial.Tutorial5;

public class T5Q3 {
	public static void main(String[] args) {
		DoublyLinkedList<Character> list = new DoublyLinkedList<Character>();
		list.add('a');
		list.add('b');
		list.add('c');
		System.out.println(list);
		list.add('z');
		System.out.println(list);
	}
}

class DoublyLinkedList<E> {
	static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;
		
		Node(Node<E> prev, E item, Node<E> next){
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
	}
	
	Node<E> head;
	Node<E> tail;
	int size;
	
	public void addLast(E item) {
		Node<E> newNode = new Node<E>(tail, item, null);
		if(head == null) 
			head = newNode;
		else 
			tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	public void add(E item) {
		addLast(item);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node<E> node = head; node != null; node = node.next) 
			sb.append(node.item).append(',').append(' ');
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}
}