package com.umwia1002.solution.lab.version2.lab6.Q3;

public class Game {
	private int numOfCards;
	private Player one;
	private Player two;
	
	Game(int n, Player one, Player two) {
		this.numOfCards = n;
		this.one = one;
		this.two = two;		
	}
	
	public void play() {
		Deck deck = new Deck();
		for(int i = 0; i < numOfCards; i++) {
			one.getCard(deck);
			two.getCard(deck);
		}

		System.out.println("Player " + one.getName() + " Card");
		one.showCards();
		System.out.println("Player " + two.getName() + " Card");
		two.showCards();
		
		int oneScore = 0;
		int twoScore = 0;
		
		for(int i = 0; i < numOfCards; i++) {
			if(one.card().compare(two.card()) > 0)
				oneScore++;
			else
				twoScore++;
		}
		
		System.out.printf("Player %s Score: %d\n", one.getName(), oneScore);
		System.out.printf("Player %s Score: %d\n", two.getName(), twoScore);
		System.out.printf("Player %s WINS!", oneScore > twoScore ? one.getName() : two.getName());
	}
}
