package com.umwia1002.solution.tutorial.Tutorial1.T1Q1;

public class Telephone {
	String areaCode;
	long number;
	static int numberOfTelephoneObject = 0;

	Telephone(String areaCode, long number) {
		this.areaCode = areaCode;
		this.number = number;
		numberOfTelephoneObject++;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String makeFullNumber() {
		return String.format("%s-%s", this.areaCode, this.number);
	}

	public void hello() {
		System.out.println("Hello, I am a telephone object");
	}
}
