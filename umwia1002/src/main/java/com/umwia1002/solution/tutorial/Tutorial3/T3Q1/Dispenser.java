package com.umwia1002.solution.tutorial.Tutorial3.T3Q1;

public enum Dispenser {
	CANDY("Candy", 1.00),
	CHIP("Chip", 3.80),
	GUM("Gum", 2.50),
	COOKIES("Cookies", 2.50);
	
	private String item;
	private double price;
	
	Dispenser(String item, double price) {
		this.item = item;
		this.price = price;
	}
	
	public String getItem() {
		return item;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void dispenseItem() {
		System.out.println(item + " is dispensed!");
	}
}
