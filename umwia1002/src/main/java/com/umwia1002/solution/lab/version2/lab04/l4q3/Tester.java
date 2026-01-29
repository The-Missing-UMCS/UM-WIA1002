package com.umwia1002.solution.lab.version2.lab04.l4q3;

import java.util.List;

public class Tester {

    public static void main(String[] args) {
        List<Course> list = getCourses();

        System.out.println("The list consist of " + list);

        int totalPoint = 0;
        int totalCredit = 0;

        for (Course course : list) {
            System.out.println(course);
            totalPoint += course.creditHour() * course.getPoint();
            totalCredit += course.creditHour();
        }

        System.out.printf("Total point is %d%n", totalPoint);
        System.out.printf("Total credit is %d%n", totalCredit);
        System.out.printf("Grade point average is %.2f%n", totalPoint / (double) totalCredit);
    }

    private static List<Course> getCourses() {
        return List.of(
            new Course("WXX101", "Programming", 5, 'B'),
            new Course("WXX201", "Networking", 4, 'C'),
            new Course("WXX301", "Operating System", 3, 'A')
        );
    }
}
