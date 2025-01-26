package com.umwia1002.solution.lab.version2.lab6.Q4;

public class Transaction {
	public static final boolean BUY = true;
	public static final boolean SELL = false;
	
	private boolean status;
	private int share;
	private int price;

	public Transaction(boolean status, int share, int price) {
		this.status = status;
		this.share = share;
		this.price = price;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public int getShare() {
		return this.share;
	}
	
	public int getPrice() {
		return this.price;
	}
	@Override
	public String toString() {
		return String.format("%s %d share at RM %d", (status) ? "Buy" : "Sell", share, price);
	}
	
}
