package com.umwia1002.solution.lab.version2.lab6.Q4;

public class Main {
	public static void main(String[] args) {
		String path = "./src/Lab6/Q4/lab6Q4.txt";
		TransactionHistory history = TransactionHistory.readHistory(path);
		history.showHistory();
		Account account = new Account();
		account.process(history.getHistory());
		System.out.println("Total Gain: " + account.getTotalGain());
	}
}
