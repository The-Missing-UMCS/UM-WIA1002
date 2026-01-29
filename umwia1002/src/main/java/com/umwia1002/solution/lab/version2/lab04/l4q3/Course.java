package com.umwia1002.solution.lab.version2.lab04.l4q3;

public record Course(
    String courseCode,
    String courseName,
    int creditHour,
    char grade
) {

    public int getPoint() {
        return switch (grade) {
            case 'A' -> 4;
            case 'B' -> 3;
            case 'C' -> 2;
            case 'D' -> 1;
            case 'E' -> 0;
            default -> -1;
        };
    }

    @Override
    public String toString() {
        return String.format("Course : %s (%s) - %d credit hours. Grade : %c -->",
            courseCode, courseName, creditHour, grade);
    }
}
