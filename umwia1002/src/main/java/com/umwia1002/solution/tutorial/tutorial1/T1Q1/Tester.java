package com.umwia1002.solution.tutorial.tutorial1.T1Q1;

public class Tester {
    public static void main(String[] args) {
        int n = 5;
        String areaCode = "03";
        long commonNo = 79676300;
        Telephone[] telephones = new Telephone[n];

        for (int i = 0; i < n; i++) {
            telephones[i] = new Telephone(areaCode, commonNo + i);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(telephones[i].fullNumber());
        }
    }
}
