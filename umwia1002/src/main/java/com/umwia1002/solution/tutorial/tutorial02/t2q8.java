package com.umwia1002.solution.tutorial.tutorial02;

import java.util.ArrayList;

public class t2q8 {

    public static void main(String[] args) {
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numOfCars.add((int) (Math.random() * 6));
            milesPerHour.add(Math.random() * 100 + 20);
        }
        displayList(numOfCars);
        displayList(milesPerHour);
    }

    private static void displayList(ArrayList<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }
}
