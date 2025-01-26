package com.umwia1002.solution.tutorial.Tutorial1.T1Q5;

public class BankAccount implements Account {
	int balance;
	
	BankAccount(int initialBalance){
		this.balance = initialBalance;
	}
	
	public int deposit(int amount) {
		this.balance += amount;
		return amount;
	}
	
	public boolean withdraw(int amount) {
		if(amount <= balance) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
}
