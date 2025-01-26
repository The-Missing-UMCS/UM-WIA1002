package com.umwia1002.solution.tutorial.Tutorial3.T3Q1;

public class CashRegister {
	private double balance;
	private double totalGain;
	private double currentPayment;
	private double currentItemPrice;
	
	CashRegister() {
		this.balance = 100;
	}
	
	public void getChange() {
		double change = currentPayment - currentItemPrice;
		if(change > balance) {
			System.out.println("Not enough balance!");
		} else {
			balance -= change;
			currentPayment = currentItemPrice = 0;
			System.out.printf("Your change: RM %.2f\n", change);
		}
			
	}
	
	public boolean isEnough() {
		return currentPayment >= currentItemPrice;
	}
	
	public void setItemPrice(double currentItemPrice) {
		this.currentItemPrice = currentItemPrice;
	}
	
	public void acceptPayment(double userPayment) {
		totalGain += userPayment;
		currentPayment += userPayment;
	}
	
	public double getCurrentPayment() {
		return currentPayment;
	}
	
	public double getTotalGain() {
		return totalGain;
	}
	
}
