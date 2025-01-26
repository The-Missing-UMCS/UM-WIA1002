package com.umwia1002.solution.tutorial.Tutorial1.T1Q1;

public class Tester {
	public static void main(String[] args) {
		Telephone[] arr = new Telephone[5];
		String areaCode = "03";
		long commonNo = 79676300;
		for(int i = 0; i < 5; i++) 
			arr[i] = new Telephone(areaCode, commonNo + i);
		for(int i = 0; i < 5; i++) 
			System.out.println(arr[i].makeFullNumber());
	}
}
