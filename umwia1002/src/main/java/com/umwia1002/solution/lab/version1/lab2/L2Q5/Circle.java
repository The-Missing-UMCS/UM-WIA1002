package com.umwia1002.solution.lab.version1.lab2.L2Q5;

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
