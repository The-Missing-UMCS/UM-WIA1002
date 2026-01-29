package com.umwia1002.solution.lab.version1.lab02.l2q5.l2q5b;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle implements Comparable<Circle> {

    private double radius;

    @Override
    public int compareTo(Circle another) {
        return Double.compare(radius, another.radius);
    }

    @Override
    public String toString() {
        return Double.toString(radius);
    }
}
