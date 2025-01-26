package com.umwia1002.solution.lab.version2.lab6.Q4;

public class Stock {
	private int share;
	private int price;

	public Stock(int share, int price) {
		this.share = share;
		this.price = price;
	}
	
	public int getShare() { 
		return this.share;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void sell(int share) {
		this.share -= share;
	}
	
	
}
