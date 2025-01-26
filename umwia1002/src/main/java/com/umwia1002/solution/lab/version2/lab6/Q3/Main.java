package com.umwia1002.solution.lab.version2.lab6.Q3;

public class Main {
	public static void main(String[] args) {
		Player one = new Player();
		Player two = new Player();
		Game game = new Game(5, one, two);
		game.play();		
	}
}
