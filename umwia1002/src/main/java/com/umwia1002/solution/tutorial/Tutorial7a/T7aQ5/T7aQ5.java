package com.umwia1002.solution.tutorial.Tutorial7a.T7aQ5;

import java.util.LinkedList;

public class T7aQ5 {
	// 1. add() = add an element to the last of the queue. If the queue fails to do so, it will throw an exception.
	// 2. offer() = add an element to the last of the queue. If the queue fails to do so, it will return false.
	// 3. poll() = remove the first element in the queue. If the queue fails to do so, it will return false.
	// 4. remove() = remove the first element in the queue. If the queue fails to so, it will throw an exception. 
	// 5. peek() = get the first element in the queue
	// 6. contains() = to check if the given element is in the queue.
	// 7. isEmpty() = to check if the queue has no element.
}

class Queue<E> {
	LinkedList<E> list;
	
	Queue() {
		this.list = new LinkedList<>();
	}
	
	public boolean contains(E elem) {
		return list.contains(elem);
	}
	
	public E peek() {
		return list.getFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
