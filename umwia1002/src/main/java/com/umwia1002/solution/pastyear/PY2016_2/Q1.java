package com.umwia1002.solution.pastyear.PY2016_2;

import java.util.Scanner;

public class Q1 {
    static final String[] WEEK_NAME = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify your day in number:");

        for(int i = 1; i <= 7; i++) {
            System.out.println(i + " for " + getWeekDay(i + 1));
        }

        int key = sc.nextInt();
        String name = getWeekDay(key);
        System.out.println("The name of the day is " + name);
        System.out.println("The following day of " + name + " is : " + getWeekDay(key - 1));
        System.out.println("The previous day of " + name + " is : " + getWeekDay(key + 1));
        System.out.println("How many days to add to the specified/current day (" + name + ")? :");
        int add = sc.nextInt();
        System.out.printf("The new day after the addition of %d day(s) is : %s", add, getWeekDay(key + add));
        sc.close();
    }

    public static String getWeekDay(int key) {
        return WEEK_NAME[key % 7];
    }
}
