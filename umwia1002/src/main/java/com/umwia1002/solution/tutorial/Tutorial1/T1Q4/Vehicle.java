package com.umwia1002.solution.tutorial.Tutorial1.T1Q4;

public abstract class Vehicle {
	double maxSpeed;
	protected double currentSpeed;

	Vehicle(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	abstract void accelerate();
	
	public double getCurrentSpeed() {
		return this.currentSpeed;
	}
	
	public double getMaxSpeed() {
		return this.maxSpeed;
	}
	
	public void pedalToTheMetal() {
		while(this.currentSpeed < maxSpeed)
			accelerate();
	}
	
	public static void main(String[] args) {
		// No...
	}
}
