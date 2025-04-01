package com.umwia1002.solution.lab.version1.lab2.L2Q5.l2q5a;

public class Circle implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle another) {
        return Double.compare(radius, another.radius);
    }

    @Override
    public String toString() {
        return Double.toString(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
