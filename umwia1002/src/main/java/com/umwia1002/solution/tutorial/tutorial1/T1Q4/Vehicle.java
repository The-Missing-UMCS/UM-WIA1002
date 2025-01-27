package com.umwia1002.solution.tutorial.tutorial1.T1Q4;

import lombok.Getter;

@Getter
public abstract class Vehicle {
	protected double maxSpeed;
	protected double currentSpeed;

	Vehicle(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	abstract void accelerate();
	
	public void pedalToTheMetal() {
		while(this.currentSpeed < maxSpeed)
			accelerate();
	}
	
	public static void main(String[] args) {
		// No...
	}
}
