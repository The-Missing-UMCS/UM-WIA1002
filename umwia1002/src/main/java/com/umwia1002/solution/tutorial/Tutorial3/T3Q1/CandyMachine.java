package com.umwia1002.solution.tutorial.Tutorial3.T3Q1;

import java.util.Scanner;

public class CandyMachine {
	private Dispenser[] dispensers;
	private CashRegister register;

	CandyMachine() {
		this.dispensers = new Dispenser[] { Dispenser.CANDY, Dispenser.CHIP, Dispenser.GUM, Dispenser.COOKIES };
		this.register = new CashRegister();
	}

	public void showItem() {
		int n = dispensers.length;
		for (int i = 0; i < n; i++)
			System.out.printf("%d. %-10s RM %.2f\n", i + 1, dispensers[i].getItem(), dispensers[i].getPrice());
	}

	public void operate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("The product:");
		showItem();

		System.out.println("Your choice: ");
		int choice = sc.nextInt() - 1;
		Dispenser tmp = dispensers[choice];
		System.out.println("Price: RM " + tmp.getPrice());
		register.setItemPrice(tmp.getPrice());

		while (!register.isEnough()) {
			System.out.printf("Current payment: %.2f; Payment: ", register.getCurrentPayment());
			register.acceptPayment(sc.nextDouble());
		}

		register.getChange();
		dispensers[choice].dispenseItem();
		sc.close();
	}
}
