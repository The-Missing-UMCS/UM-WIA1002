package com.umwia1002.solution.lab.version2.lab6.Q3;

public class ColourCard {
	private static final String[] COLOUR = {"Yello", "Red", "Green", "Blue"};
	private static final String[] NUMBER = {"One", "Two", "Three", "Four", "Five",
											"Six", "Seven", "Eight", "Nine", "Ten"};
	
	int colour;
	int number;
	
	ColourCard(int colour, int number) {
		this.colour = colour;
		this.number = number;
	}
	
	public int compare(ColourCard card) {
		int number = Integer.compare(this.number, card.number);
		return number == 0 ? Integer.compare(this.colour, card.colour) : number;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", NUMBER[number], COLOUR[colour]);
	}
}
