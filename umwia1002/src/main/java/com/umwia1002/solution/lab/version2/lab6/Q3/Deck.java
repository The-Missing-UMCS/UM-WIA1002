package com.umwia1002.solution.lab.version2.lab6.Q3;

import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	Queue<Integer> deck;
	Deck() {
		deck = new LinkedList<>();
		shuffle();
	}
	
	public void shuffle() {
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < 40; i++)
			list.add(i);
		Collections.shuffle(list);
		deck.clear();
		deck.addAll(list);
	}
	
	public Integer card() {
		return deck.remove();
	}
}
