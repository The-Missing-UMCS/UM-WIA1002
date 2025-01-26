package com.umwia1002.solution.lab.version1.lab1.L1Q3;

public class Main {
	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		Account.setAnnualInterestRate(4.5);
		account.withdraw(2500);
		account.deposit(3000);
		System.out.println(account);
	}
}
