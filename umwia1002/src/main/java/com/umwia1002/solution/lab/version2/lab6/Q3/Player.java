package com.umwia1002.solution.lab.version2.lab6.Q3;

import java.util.Queue;
import java.util.LinkedList;

public class Player {
	private String name;
	private static int index = 1;
	private Queue<ColourCard> cards;
	
	Player(String name) {
		this.name = name;
		this.cards = new LinkedList<ColourCard>();
	}
	
	Player() {
		this(String.valueOf(index++));
	}
	
	public void getCard(Deck deck) {
		int val = deck.card();
		this.cards.add(new ColourCard(val / 10, val % 10));
	}
	
	public String getName() {
		return this.name;
	}
	
	public void showCards() {
		for(ColourCard card : cards)
			System.out.print(card.toString() + " --> ");
		System.out.println();
	}
	
	public ColourCard card() {
		return cards.remove();
	}
}
