package com.umwia1002.solution.lab.version2.lab6.Q1;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.regex.*;

public class Main {
	private static final Pattern PATTERN = Pattern.compile("(D|W)\\s(\\d+)");
	
	public static void main(String[] args) {
		Queue<String> record = new ArrayDeque<>();
		String transaction = "D 400 | W 300 | W 700 | D 200 | D 450 | W 120";
		int balance = 500;
		System.out.println("Enter transactions : " + transaction);
		readTransaction(record, transaction);
		printTransaction(record);
		System.out.println("Initial Balance : " + balance);
				
		while(!record.isEmpty()) {
			String tmp = record.remove();
			int value = Integer.parseInt(tmp.substring(2));
			if(tmp.charAt(0) == 'D') {
				System.out.printf("%-25s New Balance %d\n", String.format("Withdraw %d", value), (balance += value));
			} else {
				boolean isValid = value < balance;
				if(isValid) balance -= value;
				System.out.printf("%-25s New balance %d\n", String.format("Withdraw %d %s", value, (isValid)? "" : "Rejected"), balance);
			}
		}
	}
	
	public static void readTransaction(Queue<String> record, String transaction) {
		Matcher matcher = PATTERN.matcher(transaction);
		while(matcher.find())
			record.add(matcher.group());
	}
	
	public static void printTransaction(Queue<String> record) {
		for(String tmp : record) 
			System.out.print(tmp + "  -->  ");
		System.out.println();
	}
}
