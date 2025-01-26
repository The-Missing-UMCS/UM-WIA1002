package com.umwia1002.solution.lab.version2.lab4.Q5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> words = new ArrayList<>(getWords());
		
		System.out.println("The list consists of " + words);
		
		System.out.println("Remove all the word that consists of the A character using iterator.");

		// 1. Traditional: Using iterator
		Iterator<String> ltr = words.iterator();
		while(ltr.hasNext()) {
			String str = ltr.next();
			if(str.contains("A"))
				ltr.remove();
		}

		// 2. Modern: Using removeIf
		// words.removeIf(str -> str.contains("A"));
		
		System.out.println("The updated list consists of " + words);
	}

	private static List<String> getWords() {
		return List.of("ARS", "CHE", "LEI", "MAN", "LIV", "TOT");
	}
} 
