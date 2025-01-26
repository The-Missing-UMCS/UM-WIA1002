package com.umwia1002.solution.lab.version1.lab2.L2Q5;

public class FindMax {
	public static <E extends Comparable<E>> E max(E[] list) {
		if(list == null)
			return null;
		
		E max = list[0];
		for(E item : list)
			if(item.compareTo(max) > 0)
				max = item;
		
		return max;
	}
}
