package com.umwia1002.solution.lab.version2.lab6.Q4;

import java.util.Queue;
import java.util.regex.*;
import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;

public class TransactionHistory {
	private static final Pattern PATTERN = Pattern.compile("(Buy|Sell) (\\d+) shares at RM (\\d+)");

	private Queue<Transaction> history;

	public TransactionHistory() {
		this.history = new LinkedList<>();
	}

	public static TransactionHistory readHistory(String path) {
		TransactionHistory history = new TransactionHistory();
		try (Scanner sc = new Scanner(new File(path))) {
			while (sc.hasNextLine()) {
				Matcher matcher = PATTERN.matcher(sc.nextLine());
				if (matcher.matches()) {
					boolean status = matcher.group(1).equals("Buy");
					int share = Integer.parseInt(matcher.group(2));
					int price = Integer.parseInt(matcher.group(3));
					history.history.add(new Transaction(status, share, price));
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("The file doesn't exists");
		}
		
		return history;
	}
	
	public Queue<Transaction> getHistory() {
		return this.history;
	}
	
	public void showHistory() {
		int day = 1;
		for(Transaction trans : history) 
			System.out.printf("Day %d : %s -->\n", day++, trans.toString());
	}
}
