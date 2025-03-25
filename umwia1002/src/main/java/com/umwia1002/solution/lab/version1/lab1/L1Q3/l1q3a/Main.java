package com.umwia1002.solution.lab.version1.lab1.L1Q3.l1q3a;

public class Main {
	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		account.setAnnualInterestRate(4.5);
		account.withdraw(2500);
		account.deposit(3000);
		System.out.println(account);
	}
}
